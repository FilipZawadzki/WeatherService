package com.zawadzki.weatherservice.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CoordinateEntity extends AbstractEntity {

    private String latitude;

    private String longitude;

}
