package com.zawadzki.weatherservice.service.impl;

import com.zawadzki.weatherservice.TestData;
import com.zawadzki.weatherservice.config.WeatherbitConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest
class WeatherbitAPIServiceInternalTest {

    @Autowired
    private WeatherbitConfig weatherbitConfig;

    @Autowired
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
    void shouldBuildApiUrlFromCoordinatesAndDate() {
        //given
        String shouldResult = String.format(weatherbitConfig.getUrlTemplate(),
                TestData.getFortaleza().getCoordinate().getLatitude(),
                TestData.getFortaleza().getCoordinate().getLongitude(),
                1L,
                weatherbitConfig.getApiKey());
        //when
        String jsonResponse = weatherbitAPIService.buildApiUrlFromCoordinatesAndDate(TestData.getFortaleza().getCoordinate(), TestData.getTestDateInResponse());
        //then
        assertThat(jsonResponse)
                .isNotNull()
                .isEqualTo(shouldResult);
    }

    @Test
    void shouldGetResponseForDate() {
        //given
        //when
        String response = weatherbitAPIService.getJsonResponseForDate(TestData.getJsonResponse(), LocalDate.now(clock).format(TestData.dtf));
        //then
        assertThat(response).isNotNull()
                .contains(LocalDate.now(clock).format(TestData.dtf))
                .contains(TestData.getFortaleza().getCityName());
    }

    @Test
    void shouldCalculateNumberOfDaysOfForecast_GivenDaysForwardAndToday() {
        //given
        String date = LocalDate.now(clock).plusDays(15).format(TestData.dtf);
        //when
        long days = weatherbitAPIService.calculateNumberOfDaysToForecast(date);
        //then
        assertThat(days).isEqualTo(16);
    }

}