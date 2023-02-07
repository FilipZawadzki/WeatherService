package com.zawadzki.weatherservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "weatherbit")
@Data
public class WeatherbitConfig {

    private String apiKey;

    private String urlTemplate;

}
