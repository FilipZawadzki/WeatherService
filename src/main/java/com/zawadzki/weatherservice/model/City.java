package com.zawadzki.weatherservice.model;

import lombok.Data;

@Data
public class City {

    private Country country;

    private String cityName;

    private Coordinate coordinate;


}
