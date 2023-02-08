package com.zawadzki.weatherservice.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DateValidatorTest {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Autowired
    private DateValidator dateValidator;

    @Test
    void shouldReturnFalse_WhenPatternIsNotValid() {
        //given
        //when
        boolean result = dateValidator.isPatternNotValid(LocalDate.now().format(dateTimeFormatter));
        //then
        assertThat(result).isFalse();
    }

    @Test
    void shouldReturnTrue_WhenPatternIsValid() {
        //given
        //when
        boolean result = dateValidator.isPatternNotValid(LocalDate.now().format(dateTimeFormatter));
        //then
        assertThat(result).isTrue();
    }

    @Test
    void shouldReturnTrue_WhenRangeIsNotValid() {
        //given
        //when
        boolean result = dateValidator.isRangeNotValid(LocalDate.now().plusDays(16).format(dateTimeFormatter));
        //then
        assertThat(result).isFalse();
    }

    @Test
    void shouldReturnFalse_WhenRangeIsValid() {
        //given
        //when
        boolean result = dateValidator.isRangeNotValid(LocalDate.now().plusDays(15).format(dateTimeFormatter));
        //then
        assertThat(result).isTrue();
    }

    @Test
    void isDateLessOrEqual16DaysAwayFromToday() {
        //given
        //when
        boolean result = dateValidator.isDateLessOrEqual16DaysAwayFromToday(LocalDate.now().plusDays(15).format(dateTimeFormatter));
        //then
        assertThat(result).isTrue();
    }

    @Test
    void isDateAfterOrEqualToday() {
        //given
        //when
        boolean result = dateValidator.isDateAfterOrEqualToday(LocalDate.now().plusDays(15).format(dateTimeFormatter));
        //then
        assertThat(result).isTrue();
    }
}