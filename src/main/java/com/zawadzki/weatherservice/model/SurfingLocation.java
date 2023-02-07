package com.zawadzki.weatherservice.model;

import lombok.Data;

@Data
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
