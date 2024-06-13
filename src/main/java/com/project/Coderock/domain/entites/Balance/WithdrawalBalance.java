package com.project.Coderock.domain.entites.Balance;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class WithdrawalBalance extends Balance {
    @Override
    public Double setBalance(Double amount, String create_date, String viewDate) {
        int months = this.getMonths(create_date, viewDate);
        Double gainsTotal = 0.0;
        Double gains = amount * this.getGains(create_date, viewDate);
        Double diff = gains - amount;
        if (months < 12) gainsTotal = diff - diff * 0.225;
        if (months >= 12 || months <= 24) gainsTotal = diff - diff * 0.185;
        if (months > 24) gainsTotal = diff - diff * 0.15;
        return new BigDecimal(gainsTotal).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public int getMonths(String create_date, String view_date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate creationDate = LocalDate.parse(create_date, formatter);
        LocalDate currentDate = LocalDate.parse(view_date, formatter);
        if (currentDate.isBefore(creationDate)) {
            throw new IllegalArgumentException("The withdrawal date cannot be less than the investment date");
        }
        if (currentDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("The withdrawal date cannot be a future date");
        }
        Period period = Period.between(creationDate, currentDate);
        return period.getYears() * 12 + period.getMonths();
    }
}
