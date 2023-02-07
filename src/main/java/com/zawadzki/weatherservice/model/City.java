package com.zawadzki.weatherservice.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class City extends AbstractEntity{

    @OneToOne
    private Country country;

    private String cityName;

    @OneToOne(cascade = CascadeType.ALL)
    private Coordinate coordinate;


}
