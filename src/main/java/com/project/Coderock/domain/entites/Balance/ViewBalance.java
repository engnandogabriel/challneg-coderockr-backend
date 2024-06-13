package com.project.Coderock.domain.entites.Balance;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class ViewBalance extends Balance {

    @Override
    public Double setBalance(Double amount, String create_date, String viewDate) throws Exception{
        Double gains = this.getGains(create_date, viewDate);
        double expectedBalance = amount * gains;
        return new BigDecimal(expectedBalance).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public int getMonths(String create_date, String view_date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate creationDate = LocalDate.parse(create_date, formatter);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(creationDate, currentDate);
        return period.getYears() * 12 + period.getMonths();
    }
}