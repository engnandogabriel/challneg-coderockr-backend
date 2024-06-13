package com.project.Coderock.domain.entites.Balance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ViewBalanceTest {
    @Test
    @DisplayName("Should be returned a correct value")
    void data(){
        Double view = new ViewBalance().setBalance(1000D, "10/01/2024", "");
        Assertions.assertEquals(1026.27, view);
    }
}