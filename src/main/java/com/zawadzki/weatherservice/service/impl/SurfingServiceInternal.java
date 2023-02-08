package com.zawadzki.weatherservice.service.impl;

import com.zawadzki.weatherservice.model.SurfingLocation;
import com.zawadzki.weatherservice.service.SurfingService;
import com.zawadzki.weatherservice.util.DateValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class SurfingServiceInternal implements SurfingService {

    private final DateValidator dateValidator;

    private final SurfingLocationHelper surfingLocationHelper;

    @Override
    public String calculateBestCityToSurf(String date) {

        if (dateValidator.isPatternNotValid(date) && dateValidator.isRangeNotValid(date)) {
            return "Invalid date";
        }

        List<SurfingLocation> listOfSurfingLocations = surfingLocationHelper.createListOfSurfingLocationsFromAllCities(date);

        Optional<SurfingLocation> bestSurfingLocation = listOfSurfingLocations.stream()
                .filter(location -> location.getTemperature() > 5 && location.getTemperature() < 35 &&
                        location.getWindSpeed() > 5 && location.getWindSpeed() < 18)
                .max(Comparator.comparing(s1 -> s1.getWindSpeed() * 3 + s1.getTemperature()));

        return bestSurfingLocation.orElse(new SurfingLocation()).toString();
    }
}
