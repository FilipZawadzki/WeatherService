package com.zawadzki.weatherservice.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CoordinateEntity extends AbstractEntity {

    private String latitude;

    private String longitude;

}
