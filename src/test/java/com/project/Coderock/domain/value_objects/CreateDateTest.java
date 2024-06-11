package com.project.Coderock.domain.value_objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreateDateTest {
    @Test
    @DisplayName("Should be create a new Date")
    void create() throws Exception {
        CreateDate createDate = CreateDate.validateDate("10/06/2024");
    }

    @Test
    @DisplayName("Should be throw a new Exception if a date is invalid")
    void invalidDate() throws Exception {
        Exception exception = Assertions.assertThrows(Exception.class, () -> CreateDate.validateDate("123/06/2024"));
        Assertions.assertEquals("Date Format invalid. Use DD/MM/AAAA", exception.getMessage());
    }
    @Test
    @DisplayName("Should be throw a new Exception if a future date")
    void fututeDate() throws Exception {
        Exception exception = Assertions.assertThrows(Exception.class, () -> CreateDate.validateDate("12/06/2024"));
        Assertions.assertEquals("Can not be a future date", exception.getMessage());
    }
}
