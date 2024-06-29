package com.project.Coderock.domain.entites.Balance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


class ViewBalanceTest {
    @Test
    @DisplayName("Should be returned a correct value")
    void data() throws Exception {
        LocalDate createDate = LocalDate.parse("2024-01-10");
        Double view = new ViewBalance().setBalance(1000D, createDate, "");
        Assertions.assertEquals(1026.27, view);
    }
}