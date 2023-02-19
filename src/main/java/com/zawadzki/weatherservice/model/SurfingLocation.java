package com.zawadzki.weatherservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurfingLocation {
//formatownie sie rozjezdza, tu dales 2 entery

    private CityEntity city;

    private Double temperature;

    private Double windSpeed;

    @Override
    public String toString() {
        if (city == null) {
            return "";
        }
        return city.getCountry().getCountryName() + " (" +
                city.getCityName() + ") " + temperature + " Celcius" +
                " " + windSpeed + "m/s";
    }
}
