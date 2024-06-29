package com.project.Coderock.domain.entites;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class InvestmentTest {

    @Test
    @DisplayName("Should be create a new Investment")
    void create() throws Exception{
        Investment investment = Investment.create("owner_id", "2024-06-01", 1000D);
        Assertions.assertNotNull(investment.getInvestment_id());
        Assertions.assertEquals(investment.getStatus(), "in_investment");
        Assertions.assertEquals(investment.getInvestment(), 1000);
        Assertions.assertEquals(investment.getAmount(), 0.0);
    }
    @Test
    @DisplayName("Should be throw a new Exception if a amount is invalid")
    void amountInvalid() throws Exception {
        Exception exception = Assertions.assertThrows(Exception.class, () -> Investment.create("owner_id", "2024-06-01", 0D));
        Assertions.assertEquals(exception.getMessage(), "InvalidParamError: Invalid Amount");
    }
    @Test
    @DisplayName("Must change status to withdrawn")
    void changeStatus() throws Exception {
        Investment investment = Investment.restore("c05d55b5-8d7c-4881-b67f-03eff6102def","owner_id", LocalDate.parse("2024-06-01"), 100D, 0.0, "in_investment");
        investment.setWithdrawn();
        Assertions.assertEquals("withdrawn", investment.getStatus());
    }
}