package com.zawadzki.weatherservice.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Coordinate extends AbstractEntity {

    private String latitude;

    private String longitude;

}
