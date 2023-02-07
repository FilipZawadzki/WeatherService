package com.zawadzki.weatherservice.service.impl;

import com.zawadzki.weatherservice.TestData;
import com.zawadzki.weatherservice.config.WeatherbitConfig;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest
class WeatherbitAPIServiceInternalTest {

    @Autowired
    public WeatherbitConfig weatherbitConfig;

    @Autowired
    private WeatherbitAPIServiceInternal weatherbitAPIService;

    @MockBean
    private Clock clock;


    @BeforeEach
    void setUpClock(){
        when(clock.getZone()).thenReturn(ZoneId.of("GMT"));
    }
    @Test
    void shouldBuildApiUrlFromCoordinatesAndDate() {
        //given
        when(clock.instant()).thenReturn(
                Instant.parse("2023-02-06T10:05:23.653Z"));
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
    void shouldGetJsonResponseForUrl() {
        //given
        //when
        //then
    }
}