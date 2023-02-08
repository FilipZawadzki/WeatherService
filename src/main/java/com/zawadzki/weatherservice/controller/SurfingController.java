package com.zawadzki.weatherservice.controller;

import com.zawadzki.weatherservice.service.SurfingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather/cities")
public class SurfingController {

    private final SurfingService surfingService;

    @RequestMapping("/surfing/best{date}")
    @ResponseStatus(HttpStatus.OK)
    public String getBestSurfingLocation(@RequestParam("date") String date) {
        return surfingService.calculateBestCityToSurf(date);
    }

}
