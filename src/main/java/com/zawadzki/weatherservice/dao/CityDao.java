package com.zawadzki.weatherservice.dao;

import com.zawadzki.weatherservice.model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDao extends JpaRepository<CityEntity, Long> {
}
