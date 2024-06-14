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
    private String investmentId;
    @Column(name = "owner_id")
    private String ownerId;
    @Column(name = "create_date")
    private String createDate;
    @Column(name="investment")
    private Double investment;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "status")
    private String status;


    public InvestmentModel(String investment_id, String owner_id, String create_date, Double investment, Double amount, String status) {
        this.investmentId = investment_id;
        this.ownerId = owner_id;
        this.createDate = create_date;
        this.investment = investment;
        this.amount = amount;
        this.status = status;
    }

    public InvestmentModel() {
    }

    public String getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(String investment_id) {
        this.investmentId = investment_id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String owner_id) {
        this.ownerId = owner_id;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String create_date) {
        this.createDate = create_date;
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
