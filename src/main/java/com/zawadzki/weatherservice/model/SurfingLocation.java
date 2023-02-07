package com.zawadzki.weatherservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SurfingLocation extends AbstractEntity {

    @OneToOne
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
