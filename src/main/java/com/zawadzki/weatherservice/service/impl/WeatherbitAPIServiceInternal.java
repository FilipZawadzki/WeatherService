package com.zawadzki.weatherservice.service.impl;

import com.zawadzki.weatherservice.config.WeatherbitConfig;
import com.zawadzki.weatherservice.model.Coordinate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class WeatherbitAPIServiceInternal {

    private final WeatherbitConfig weatherbitConfig;

    private final Clock clock;

    protected String getJsonResponseForUrl(String weatherbitApiUrl) {
        StringBuilder sb = new StringBuilder();

        try {
            URL url = new URL(weatherbitApiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HttpsResponseCode: " + conn.getResponseCode());
            } else {
                Scanner scn = new Scanner(url.openStream());
                while (scn.hasNext()) {
                    sb.append(scn.nextLine());
                }
                scn.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }

    protected String buildApiUrlFromCoordinatesAndDate(Coordinate coordinate, String date) {
        long daysOfForecast = calculateNumberOfDaysToForecast(date);
        return String.format(weatherbitConfig.getUrlTemplate(), coordinate.getLatitude(), coordinate.getLongitude(), daysOfForecast, weatherbitConfig.getApiKey());
    }

    private long calculateNumberOfDaysToForecast(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateToCalculate = LocalDate.parse(date, dtf);

        return Math.abs(ChronoUnit.DAYS.between(dateToCalculate, LocalDate.now(clock))) + 1;
    }

}
