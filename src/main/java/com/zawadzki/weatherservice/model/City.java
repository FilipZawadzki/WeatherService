package com.zawadzki.weatherservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class City extends AbstractEntity{

    @OneToOne
    private Country country;

    private String cityName;

    @OneToOne
    private Coordinate coordinate;


}
