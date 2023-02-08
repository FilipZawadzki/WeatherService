package com.zawadzki.weatherservice.service.impl;

import com.zawadzki.weatherservice.TestData;
import com.zawadzki.weatherservice.model.SurfingLocation;
import com.zawadzki.weatherservice.util.DateValidator;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SurfingServiceInternalTest {

    @Mock
    private DateValidator dateValidator;

    @InjectMocks
    private SurfingServiceInternal surfingServiceInternal;

    @Mock
    private SurfingLocationHelper surfingLocationHelper;

    @Test
    void shouldCalculateBestCityToSurf() {
        //given
        List<SurfingLocation> listOfSurfingLocations = new ArrayList<>(List.of(TestData.getFortalezaSurfingLocation(), TestData.getJastarniaSurfingLocation()));
        //when
        Mockito.when(surfingLocationHelper.createListOfSurfingLocationsFromAllCities(TestData.getTestDateInResponse())).thenReturn(listOfSurfingLocations);
        Mockito.when(dateValidator.isPatternNotValid(TestData.getTestDateInResponse())).thenReturn(false);
        Mockito.when(dateValidator.isRangeNotValid(TestData.getTestDateInResponse())).thenReturn(false);

        String result = surfingServiceInternal.calculateBestCityToSurf(TestData.getTestDateInResponse());
        //then
        assertThat(result).isEqualTo(TestData.getJastarniaSurfingLocation().toString());
    }
}