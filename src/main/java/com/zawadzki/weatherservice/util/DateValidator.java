package com.zawadzki.weatherservice.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Component
@RequiredArgsConstructor
public class DateValidator {

    private final Clock clock;

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public boolean isPatternNotValid(String date) {
        try {
            dtf.parse(date);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    public boolean isRangeNotValid(String date) {
        boolean isDateAfterToday = isDateAfterOrEqualToday(date);
        boolean isDateLessOrEqual16DaysAway = isDateLessOrEqual16DaysAwayFromToday(date);

        return !(isDateAfterToday && isDateLessOrEqual16DaysAway);
    }

    public boolean isDateLessOrEqual16DaysAwayFromToday(String date) {
        return LocalDate.now(clock).plusDays(15).isAfter(LocalDate.parse(date, dtf)) ||
                LocalDate.now(clock).plusDays(15).isEqual(LocalDate.parse(date, dtf));

    }

    public boolean isDateAfterOrEqualToday(String date) {
        return !LocalDate.now(clock).isAfter(LocalDate.parse(date, dtf)) || LocalDate.now(clock).isEqual(LocalDate.parse(date, dtf));
    }

}
