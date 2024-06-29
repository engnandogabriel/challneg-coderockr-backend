package com.project.Coderock.domain.entites;

import com.project.Coderock.domain.Exceptions.InvalidParamError;
import com.project.Coderock.domain.entites.Balance.BalanceFactory;
import com.project.Coderock.domain.value_objects.CreateDate;
import com.project.Coderock.domain.value_objects.Status;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.UUID;

public class Investment {
    private String investment_id;
    private String owner_id;
    private LocalDate create_date;
    private Double investment;
    private Double amount;
    private Status status;

    public Investment() {
    }

    private Investment(String investment_id, String owner_id, LocalDate create_date, Double investment, Double amount, Status status) {
        this.investment_id = investment_id;
        this.owner_id = owner_id;
        this.create_date = create_date;
        this.amount = amount;
        this.investment = investment;
        this.status = status;
    }

    public static Investment create(String owner_id, String create_date, Double investment) throws Exception {
        UUID id = UUID.randomUUID();
        String status = "in_investment";
        if (investment.doubleValue() <= 0) throw new InvalidParamError("Invalid Amount");
        return new Investment(id.toString(), owner_id, new CreateDate(create_date).getCreate_date(), investment, 0.0, Status.create());
    }

    public static Investment restore(String id, String owner_id, LocalDate create_date, Double investment, Double amount, String status) throws Exception {
        return new Investment(id, owner_id, create_date, investment, amount, Status.restore(status));
    }

    public String getInvestment_id() {
        return investment_id;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public LocalDate getCreate_date() {
        return create_date;
    }

    public Double getInvestment() {
        return investment;
    }

    public void setInvestment(Double investment) {
        this.investment = investment;
    }

    public Double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status.getStatus();
    }

    public void setWithdrawn() throws Exception {
        this.status.setWithdrawn();
    }

    public void viewBalanceInvestment() throws Exception {
        this.amount = BalanceFactory.balance("view_balance", this.investment, this.getCreate_date(), "");
    }

    public void calculateBalance(String view_date) throws Exception {
        Double gains =  BalanceFactory.balance("calculate", this.investment, this.getCreate_date(), view_date);
        System.out.println(gains);
        this.amount =  new BigDecimal(this.investment + gains).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
