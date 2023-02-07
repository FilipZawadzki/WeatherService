package com.zawadzki.weatherservice.dbdata;

import com.zawadzki.weatherservice.dao.CityDao;
import com.zawadzki.weatherservice.dao.CountryDao;
import com.zawadzki.weatherservice.model.City;
import com.zawadzki.weatherservice.model.Coordinate;
import com.zawadzki.weatherservice.model.Country;
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
    public void run(ApplicationArguments args) throws Exception {
        Country brazil = new Country("Brazil");
        Country poland = new Country("Poland");
        Country barbados = new Country("Barbados");
        Country cyprus = new Country("Cyprus");
        Country mauritius = new Country("Mauritius");

        countryDao.saveAll(List.of(brazil, barbados, poland, mauritius, cyprus));

        City jastarnia = new City(poland, "Jastarnia", new Coordinate("54.696", "18.678"));
        City fortaleza = new City(brazil, "Fortaleza", new Coordinate("-3.731", "-38.526"));
        City bridgetown = new City(barbados, "Bridgetown", new Coordinate("13.100", "-59.616"));
        City pissouri = new City(cyprus, "Pissouri", new Coordinate("34.666", "32.700"));
        City leMorne = new City(mauritius, "Le Morne", new Coordinate("-20.456", "57.308"));

        cityDao.saveAll(List.of(jastarnia, fortaleza, bridgetown, pissouri, leMorne));
    }
}
