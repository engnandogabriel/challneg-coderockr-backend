package com.project.Coderock.infra.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "investments")
public class InvestmentModel {
    @Id
    @Column(name = "investment_id")
    private String investmentId;
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "owner_id", nullable = false, foreignKey = @ForeignKey(name = "Investment_owner_id"))
    private OwnerModel ownerId;
    @Column(name = "create_date")
    private LocalDate createDate;
    @Column(name="investment")
    private Double investment;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "status")
    private String status;


    public InvestmentModel(String investment_id, OwnerModel owner_id, LocalDate create_date, Double investment, Double amount, String status) {
        this.investmentId = investment_id;
        this.ownerId = owner_id;
        this.createDate = create_date;
        this.investment = investment;
        this.amount = amount;
        this.status = status;
    }

    public InvestmentModel(OwnerModel ownerId) {
        this.ownerId = ownerId;
    }

    public InvestmentModel() {
    }

    public String getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(String investment_id) {
        this.investmentId = investment_id;
    }

    public OwnerModel getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(OwnerModel owner_id) {
        this.ownerId = owner_id;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate create_date) {
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
