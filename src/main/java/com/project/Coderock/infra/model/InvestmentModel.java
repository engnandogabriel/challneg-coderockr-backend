package com.project.Coderock.infra.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "investments")
public class InvestmentModel {
    @Id
    @Column(name = "investment_id")
    private String investment_id;
    @Column(name = "owner_id")
    private String owner_id;
    @Column(name = "create_date")
    private String create_date;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "status")
    private String status;


    public InvestmentModel(String investment_id, String owner_id, String create_date, Double amount, String status) {
        this.investment_id = investment_id;
        this.owner_id = owner_id;
        this.create_date = create_date;
        this.amount = amount;
        this.status = status;
    }

    public InvestmentModel() {
    }

    public String getInvestment_id() {
        return investment_id;
    }

    public void setInvestment_id(String investment_id) {
        this.investment_id = investment_id;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
