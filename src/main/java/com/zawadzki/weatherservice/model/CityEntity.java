package com.zawadzki.weatherservice.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CityEntity extends AbstractEntity {

    @OneToOne
    private CountryEntity country;

    private String cityName;

    @OneToOne(cascade = CascadeType.ALL)
    private CoordinateEntity coordinate;


}
