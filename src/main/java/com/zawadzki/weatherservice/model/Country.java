package com.zawadzki.weatherservice.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Country extends AbstractEntity{

    private String countryName;

}
