package com.project.Coderock.domain.entites.Balance;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class WithdrawalBalanceTest {
    @Test
    @DisplayName("Should be returned a correct value in range of 12 months")
    void balanceOf12() throws Exception {
        LocalDate createDate = LocalDate.parse("2024-01-10");
        Double value = new WithdrawalBalance().setBalance(1000D, createDate, "2024-06-13");
        System.out.println(value);
        Assert.assertEquals(value, 21.41, 0.01);
    }

    @Test
    @DisplayName("Should be returned a correct value in range between 12 and 24 months")
    void balanceOf12and24() throws Exception {
        LocalDate createDate = LocalDate.parse("2023-01-10");
        Double value = new WithdrawalBalance().setBalance(1000D, createDate, "2024-06-13");
        Assert.assertEquals(value, 75.12, 0.01);
    }

    @Test
    @DisplayName("The correct amount must be returned for more than 24 months")
    void balanceOf24() throws Exception {
        LocalDate createDate = LocalDate.parse("2022-01-10");
        Double value = new WithdrawalBalance().setBalance(1000D, createDate, "2024-06-13");
        Assert.assertEquals(value, 137.96, 0.01);
    }

    @Test
    @DisplayName("Can not be calculated with a date invalid")
    void testDateInvalid() throws Exception {
        LocalDate createDate = LocalDate.parse("2024-01-10");
        Exception exception = Assert.assertThrows(Exception.class, () -> new WithdrawalBalance().setBalance(1000D, createDate,"20244-06-13"));
        Assert.assertEquals(exception.getMessage(), "InvalidParamError: Date Format invalid. Use YYYY-MM-DD");
    }

    @Test
    @DisplayName("Can not be calculated with a date in past")
    void testDatePast() throws Exception {
        LocalDate createDate = LocalDate.parse("2024-01-10");
        Exception exception = Assert.assertThrows(Exception.class, () -> new WithdrawalBalance().setBalance(1000D, createDate,"2024-06-13"));
        Assert.assertEquals(exception.getMessage(), "InvalidParamError: The withdrawal date cannot be less than the investment date");
    }
    @Test
    @DisplayName("Can not be calculated with a date in future")
    void testDateFuture() throws Exception {
        LocalDate createDate = LocalDate.parse("2024-01-10");
        LocalDate futureDate = LocalDate.now().plusMonths(1);
        Exception exception = Assert.assertThrows(Exception.class, () -> new WithdrawalBalance().setBalance(1000D, createDate, futureDate.toString()));
        System.out.println(exception);
        Assert.assertEquals(exception.getMessage(), "InvalidParamError: The withdrawal date cannot be a future date");
    }

    @Test
    @DisplayName("Can not be calculated with a date of created equal a date of withdrawal")
    void testWithdrawalEqualDate() throws Exception {
        LocalDate createDate = LocalDate.parse("2024-01-01");
        LocalDate withdrawalDate = LocalDate.parse("2024-01-01");
        Exception exception = Assert.assertThrows(Exception.class, () -> new WithdrawalBalance().setBalance(1000D, createDate, withdrawalDate.toString()));
        Assert.assertEquals(exception.getMessage(), "InvalidOperation: Invalid Period");
    }
}