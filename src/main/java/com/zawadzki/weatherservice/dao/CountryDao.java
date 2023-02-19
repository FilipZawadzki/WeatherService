package com.zawadzki.weatherservice.dao;

import com.zawadzki.weatherservice.model.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//zmien pakiet na repository i intefejsy na CountryDaoRepository itp
public interface CountryDao extends JpaRepository<CountryEntity, Long> {
}
