package com.zawadzki.weatherservice.dao;

import com.zawadzki.weatherservice.model.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinateDao extends JpaRepository<Coordinate, Long> {
}
