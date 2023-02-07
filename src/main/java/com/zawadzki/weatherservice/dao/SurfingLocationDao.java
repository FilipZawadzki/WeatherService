package com.zawadzki.weatherservice.dao;

import com.zawadzki.weatherservice.model.SurfingLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurfingLocationDao extends JpaRepository<SurfingLocation, Long> {
}
