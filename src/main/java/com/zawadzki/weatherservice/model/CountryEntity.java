package com.zawadzki.weatherservice.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CountryEntity extends AbstractEntity {

    private String countryName;

}
