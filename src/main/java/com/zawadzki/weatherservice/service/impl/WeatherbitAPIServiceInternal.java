package com.zawadzki.weatherservice.service.impl;

import com.zawadzki.weatherservice.config.WeatherbitConfig;
import com.zawadzki.weatherservice.model.CoordinateEntity;
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
 class WeatherbitAPIServiceInternal {

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

    protected String buildApiUrlFromCoordinatesAndDate(CoordinateEntity coordinateEntity, String date) {
        long daysOfForecast = calculateNumberOfDaysToForecast(date);
        return String.format(weatherbitConfig.getUrlTemplate(), coordinateEntity.getLatitude(), coordinateEntity.getLongitude(), daysOfForecast, weatherbitConfig.getApiKey());
    }

    protected long calculateNumberOfDaysToForecast(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateToCalculate = LocalDate.parse(date, dtf);

        return Math.abs(ChronoUnit.DAYS.between(dateToCalculate, LocalDate.now(clock))) + 1;
    }

    protected String getJsonResponseForDate(String apiResponseInJson, String date) {
        var dateIndex = apiResponseInJson.indexOf(date);
        if (dateIndex != -1) {
            return apiResponseInJson.substring(dateIndex);
        }
        return apiResponseInJson;
    }

}
