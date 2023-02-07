package com.zawadzki.weatherservice.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Coordinate extends AbstractEntity{

    private String latitude;

    private String longitude;

}
