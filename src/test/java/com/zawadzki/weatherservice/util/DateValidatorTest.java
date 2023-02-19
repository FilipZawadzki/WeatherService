package com.zawadzki.weatherservice.util;

import com.zawadzki.weatherservice.TestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DateValidatorTest {

    private static final DateTimeFormatter invalidDateFormat = DateTimeFormatter.ofPattern("MM-yyyy-dd");

    @Autowired
    private DateValidator dateValidator;

    @Test
    void shouldReturnFalse_WhenPatternIsNotValid() {
        //given
        //when
        boolean result = dateValidator.isPatternNotValid(LocalDate.now().format(invalidDateFormat));
        //then
        assertThat(result).isFalse();
    }

    @Test
    void shouldReturnTrue_WhenPatternIsValid() {
        //given
        //when
        boolean result = dateValidator.isPatternNotValid(LocalDate.now().format(TestData.dtf));
        //then
        assertThat(result).isTrue();
    }

    @Test
    void shouldReturnTrue_WhenRangeIsNotValid() {
        //given when mozna razem napisac i enter przed then
        //given
        //when
        boolean result = dateValidator.isRangeNotValid(LocalDate.now().plusDays(16).format(TestData.dtf));
        //then
        assertThat(result).isTrue();
    }

    @Test
    void shouldReturnFalse_WhenRangeIsValid() {
        //given
        //when
        boolean result = dateValidator.isRangeNotValid(LocalDate.now().plusDays(15).format(TestData.dtf));
        //then
        assertThat(result).isFalse();
    }

    @Test
    void isDateLessOrEqual16DaysAwayFromToday() {
        //given
        //when
        boolean result = dateValidator.isDateLessOrEqual16DaysAwayFromToday(LocalDate.now().plusDays(15).format(TestData.dtf));
        //then
        assertThat(result).isTrue();
    }

    @Test
    void isDateAfterOrEqualToday() {
        //given
        //when
        boolean result = dateValidator.isDateAfterOrEqualToday(LocalDate.now().plusDays(15).format(TestData.dtf));
        //then
        assertThat(result).isTrue();
    }
}