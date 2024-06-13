package com.project.Coderock.domain.entites.Balance;

public class BalanceFactory {
    public static Double balance(String type, Double investment, String create_date, String viewDate) throws Exception {
        if (type.equals("view_balance")) return new ViewBalance().setBalance(investment, create_date, viewDate);
        if (type.equals("calculate")) return new ViewBalance().setBalance(investment, create_date, viewDate);
        throw new Exception("Invalid type");
    }
}
