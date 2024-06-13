package com.project.Coderock.domain.entites.Balance;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WithdrawalBalanceTest {
    @Test
    @DisplayName("Should be returned a correct value in range of 12 months")
    void balanceOf12() throws Exception{
        Double value = new WithdrawalBalance().setBalance(1000D, "10/01/2024", "13/06/2024");
        System.out.println(value);
        Assert.assertEquals(value,21.41, 0.01);
    }
    @Test
    @DisplayName("Should be returned a correct value in range between 12 and 24 months")
    void balanceOf12and24() throws Exception{
        Double value = new WithdrawalBalance().setBalance(1000D, "10/01/2023", "13/06/2024");
        Assert.assertEquals(value,75.12, 0.01);
    }
    @Test
    @DisplayName("The correct amount must be returned for more than 24 months")
    void balanceOf24() throws Exception{
        Double value = new WithdrawalBalance().setBalance(1000D, "10/05/2022", "13/06/2024");
        Assert.assertEquals(value,117.68, 0.01);
    }
}