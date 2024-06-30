package com.project.Coderock.domain.entites.Balance;

import com.project.Coderock.domain.Exceptions.InvalidOperations;
import com.project.Coderock.domain.Exceptions.InvalidParamError;
import com.project.Coderock.domain.value_objects.CreateDate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class WithdrawalBalance extends Balance {
    @Override
    public Double setBalance(Double amount, LocalDate create_date, String viewDate) throws Exception {
        int months = this.getMonths(create_date, viewDate);
        if(months < 1) throw new InvalidOperations("Invalid Period");
        Double gainsTotal = 0.0;
        Double gains = amount * this.getGains(create_date, viewDate);
        Double diff = gains - amount;
        if (months < 12) gainsTotal = diff - diff * 0.225;
        if (months >= 12 || months <= 24) gainsTotal = diff - diff * 0.185;
        if (months > 24) gainsTotal = diff - diff * 0.15;
        return new BigDecimal(gainsTotal).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public int getMonths(LocalDate create_date, String view_date) throws Exception {
        if (!view_date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new InvalidParamError("Date Format invalid. Use YYYY-MM-DD");
        }
        LocalDate currentDate = LocalDate.parse(view_date);
        if (currentDate.isBefore(create_date)) {
            System.out.println("ola");
            throw new InvalidParamError("The withdrawal date cannot be less than the investment date");
        }
        if (currentDate.isAfter(LocalDate.now())) {
            throw new InvalidParamError ("The withdrawal date cannot be a future date");
        }
        Period period = Period.between(create_date, currentDate);
        return period.getYears() * 12 + period.getMonths();

    }
}
