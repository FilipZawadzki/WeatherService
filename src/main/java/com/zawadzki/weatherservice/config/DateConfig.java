package com.zawadzki.weatherservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class DateConfig {

    @Bean
    private Clock clock(){
        return Clock.systemDefaultZone();
    }

}
