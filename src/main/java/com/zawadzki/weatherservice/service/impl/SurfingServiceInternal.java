package com.zawadzki.weatherservice.service.impl;

import com.zawadzki.weatherservice.service.SurfingService;
import com.zawadzki.weatherservice.util.DateValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class SurfingServiceInternal implements SurfingService {

    private final DateValidator dateValidator;

    @Override
    public String calculateBestCityToSurf(String date) {

        if (dateValidator.isPatternNotValid(date) && dateValidator.isRangeNotValid(date)) {
            return "Invalid date";
        }

        return null;
    }
}
