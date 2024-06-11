package com.project.Coderock.domain.entites;

import com.project.Coderock.domain.value_objects.CreateDate;
import com.project.Coderock.domain.value_objects.Status;

import java.util.UUID;

public class Investment {
    private String investment_id;
    private String owner_id;
    private CreateDate create_date;
    private Double amount;
    private Status status;

    public Investment() {
    }

    private Investment(String investment_id, String owner_id, CreateDate create_date, Double amount, Status status) {
        this.investment_id = investment_id;
        this.owner_id = owner_id;
        this.create_date = create_date;
        this.amount = amount;
        this.status = status;
    }

    public static Investment create(String owner_id, String create_date, Double amount) throws Exception {
        UUID id = UUID.randomUUID();
        String status = "in_investment";
        if(amount.doubleValue() <= 0) throw new Exception("Invalid Amount");
        return new Investment(id.toString(), owner_id, CreateDate.validateDate(create_date), amount, Status.create());
    }

    public static Investment restore(String id, String owner_id, String create_date, Double amount, String status) throws Exception {
        return new Investment(id, owner_id, CreateDate.restore(create_date), amount, Status.restore(status));
    }

    public String getInvestment_id() {
        return investment_id;
    }


    public String getOwner_id() {
        return owner_id;
    }

    public String getCreate_date() {
        return create_date.getCreate_date();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status.getStatus();
    }
    public void setWithdrawn() throws Exception{
        this.status.setWithdrawn();
    }
}
