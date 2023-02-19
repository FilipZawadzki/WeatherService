package com.zawadzki.weatherservice.service.impl;

import com.zawadzki.weatherservice.TestData;
import com.zawadzki.weatherservice.config.WeatherbitConfig;
import com.zawadzki.weatherservice.dao.CityDao;
import com.zawadzki.weatherservice.model.CityEntity;
import com.zawadzki.weatherservice.model.SurfingLocation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

//oprocz testow servicu prosze o zrobienie testow integracyjnych ktore przetestuja cale flow (mozesz uzyc wiremocka zeby zamockowac clienta, ewentualnie zamockowac sama klase client)
@SpringBootTest
class SurfingLocationHelperTest {

    @InjectMocks
    private SurfingLocationHelper surfingLocationHelper;

    @Autowired
    private WeatherbitConfig weatherbitConfig;

    @Mock
    private CityDao cityDao;

    @Mock
    private WeatherbitAPIServiceInternal weatherbitAPIService;

    @MockBean
    private Clock clock;


    @BeforeEach
    void setUpClock() {
        when(clock.getZone()).thenReturn(ZoneId.of("GMT"));

        when(clock.instant()).thenReturn(
                Instant.parse("2023-02-06T00:00:00.000Z"));
    }

    @Test
    void createSurfingLocationForDateFromJSON() {
        //given
        //when
        Mockito.when(weatherbitAPIService.getJsonResponseForDate(TestData.getJsonResponse(), TestData.getTestDateInResponse()))
                .thenReturn(TestData.getJsonResponseForTestDate());

        SurfingLocation surfingLocation = surfingLocationHelper.createSurfingLocationForDateFromJSON(TestData.getFortaleza(), TestData.getJsonResponse(), TestData.getTestDateInResponse());
        //then
        assertThat(surfingLocation)
                .extracting(SurfingLocation::getCity)
                .extracting(CityEntity::getCityName)
                .isEqualTo(TestData.getFortaleza().getCityName());
    }

    @Test
    void createListOfSurfingLocationsFromAllCities() {
        //given
        List<CityEntity> listOfCities = new ArrayList<>(List.of(TestData.getFortaleza()));
        String latitude = TestData.getFortaleza().getCoordinate().getLatitude();
        String longitude = TestData.getFortaleza().getCoordinate().getLongitude();
        String url = String.format(weatherbitConfig.getUrlTemplate(), latitude, longitude, 1L, weatherbitConfig.getApiKey());
        //rob entery pomiedzy blokami given, when i then
        //when
        Mockito.when(cityDao.findAll())
                .thenReturn(listOfCities);
        Mockito.when(weatherbitAPIService.buildApiUrlFromCoordinatesAndDate(listOfCities.get(0).getCoordinate(), TestData.getTestDateInResponse()))
                .thenReturn(url);
        Mockito.when(weatherbitAPIService.getJsonResponseForUrl(url))
                .thenReturn(TestData.getJsonResponse());
        Mockito.when(weatherbitAPIService.getJsonResponseForDate(TestData.getJsonResponse(), TestData.getTestDateInResponse()))
                .thenReturn(TestData.getJsonResponseForTestDate());

        List<SurfingLocation> listOfSurfingLocations = surfingLocationHelper.createListOfSurfingLocationsFromAllCities(TestData.getTestDateInResponse());
        //then
        assertThat(listOfSurfingLocations)
                .isNotNull()
                .extracting(SurfingLocation::getCity)
                .extracting(CityEntity::getCityName)
                .containsExactlyInAnyOrder(TestData.getFortaleza().getCityName());
    }
}