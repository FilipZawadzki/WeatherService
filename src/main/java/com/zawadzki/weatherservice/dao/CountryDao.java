package com.zawadzki.weatherservice.dao;

import com.zawadzki.weatherservice.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryDao extends JpaRepository<Country, Long> {
}
