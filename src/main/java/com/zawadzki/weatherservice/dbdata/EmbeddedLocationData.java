package com.zawadzki.weatherservice.dbdata;

import com.zawadzki.weatherservice.dao.CityDao;
import com.zawadzki.weatherservice.dao.CountryDao;
import com.zawadzki.weatherservice.model.CityEntity;
import com.zawadzki.weatherservice.model.CoordinateEntity;
import com.zawadzki.weatherservice.model.CountryEntity;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class EmbeddedLocationData implements ApplicationRunner {

    private final CountryDao countryDao;

    private final CityDao cityDao;

    @Override
    public void run(ApplicationArguments args) {
        CountryEntity brazil = new CountryEntity("Brazil");
        CountryEntity poland = new CountryEntity("Poland");
        CountryEntity barbados = new CountryEntity("Barbados");
        CountryEntity cyprus = new CountryEntity("Cyprus");
        CountryEntity mauritius = new CountryEntity("Mauritius");

        countryDao.saveAll(List.of(brazil, barbados, poland, mauritius, cyprus));

        CityEntity jastarnia = new CityEntity(poland, "Jastarnia", new CoordinateEntity("54.696", "18.678"));
        CityEntity fortaleza = new CityEntity(brazil, "Fortaleza", new CoordinateEntity("-3.731", "-38.526"));
        CityEntity bridgetown = new CityEntity(barbados, "Bridgetown", new CoordinateEntity("13.100", "-59.616"));
        CityEntity pissouri = new CityEntity(cyprus, "Pissouri", new CoordinateEntity("34.666", "32.700"));
        CityEntity leMorne = new CityEntity(mauritius, "Le Morne", new CoordinateEntity("-20.456", "57.308"));

        cityDao.saveAll(List.of(jastarnia, fortaleza, bridgetown, pissouri, leMorne));
    }
}
