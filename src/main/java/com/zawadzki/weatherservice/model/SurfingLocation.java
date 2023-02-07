package com.zawadzki.weatherservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurfingLocation {


    private City city;

    private Double temperature;

    private Double windSpeed;

    @Override
    public String toString() {
        return city.getCountry().getCountryName() + " (" +
                city.getCityName() + ") " + temperature + " Celcius" +
                " " + windSpeed + "m/s";
    }
}
