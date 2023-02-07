package com.zawadzki.weatherservice.service.impl;

import com.zawadzki.weatherservice.dao.CityDao;
import com.zawadzki.weatherservice.model.CityEntity;
import com.zawadzki.weatherservice.model.SurfingLocation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
class SurfingLocationHelper {

    private final WeatherbitAPIServiceInternal weatherbitAPIService;

    private final CityDao cityDao;

    protected SurfingLocation createSurfingLocationForDateFromJSON(CityEntity city, String apiJsonResponse, String date) {
        String apiResponseForDateInJson = weatherbitAPIService.getResponseForDate(apiJsonResponse, date);

        String[] data = Arrays.stream(apiResponseForDateInJson.split(","))
                .filter(str -> str.contains("city_name") ||
                        str.contains("wind_spd") ||
                        str.contains("\"temp\":") ||
                        str.contains("datetime"))
                .map(str -> str.replaceAll("[]{}\"]", ""))
                .toArray(String[]::new);

        Double windSpeed = Double.parseDouble(Arrays.stream(Arrays.stream(data).filter(str1 -> str1.contains("wind_spd")).findFirst().orElse("0.0")
                .split(":")).filter(str2 -> str2.matches("[0-9.]*[0-9]")).findFirst().orElse("0.0"));

        Double avgTemp = Double.parseDouble(Arrays.stream(data).filter(str1 -> str1.contains("temp")).map(str2 -> Arrays.stream(str2.split(":"))
                .filter(str3 -> str3.matches("[0-9.]*[0-9]")).findFirst().orElse("0.0")).findFirst().orElse("0.0"));

        SurfingLocation surfingLocation = new SurfingLocation();
        surfingLocation.setCity(city);
        surfingLocation.setTemperature(avgTemp);
        surfingLocation.setWindSpeed(windSpeed);

        return surfingLocation;
    }

    protected List<SurfingLocation> createListOfSurfingLocationsFromAllCities(String date) {

        List<SurfingLocation> listOfSurfingLocations = new ArrayList<>();

        List<CityEntity> listOfCities = cityDao.findAll();
        for (CityEntity city : listOfCities) {
            String apiUrlForCity = weatherbitAPIService.buildApiUrlFromCoordinatesAndDate(city.getCoordinate(), date);
            String apiResponse = weatherbitAPIService.getJsonResponseForUrl(apiUrlForCity);
            SurfingLocation surfingLocation = createSurfingLocationForDateFromJSON(city, apiResponse, date);
            listOfSurfingLocations.add(surfingLocation);
        }
        return listOfSurfingLocations;
    }


}
