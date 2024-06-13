package com.project.Coderock.domain.entites.Balance;

public abstract class Balance {
    protected Double tax = 0.0052;

    public abstract Double setBalance(Double amount, String create_date, String viewDate);

    public abstract int getMonths(String create_date, String view_date);

    protected double getGains(String create_date, String viewDate) {
        int months = this.getMonths(create_date, viewDate);
        if (months <= 0) return 0.0;
        return Math.pow(1 + this.tax, months);
    }
}


