package com.project.Coderock.domain.value_objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class CreateDateTest {
    @Test
    @DisplayName("Should be create a new Date")
    void create() throws Exception {
        CreateDate createDate = new CreateDate("2024-06-29");
    }

    @Test
    @DisplayName("Should be throw a new Exception if a date is invalid")
    void invalidDate() throws Exception {
        Exception exception = Assertions.assertThrows(Exception.class, () -> new CreateDate("20244-06-30"));
        Assertions.assertEquals("InvalidParamError: Date Format invalid. Use YYYY-MM-DD", exception.getMessage());
    }
    @Test
    @DisplayName("Should be throw a new Exception if a future date")
    void fututeDate() throws Exception {
        LocalDate localDate = LocalDate.now().plusMonths(2);
        System.out.println(localDate.toString());
        Exception exception = Assertions.assertThrows(Exception.class, () -> new CreateDate(localDate.toString()));
        Assertions.assertEquals("InvalidParamError: Can not be a future date", exception.getMessage());
    }
}
