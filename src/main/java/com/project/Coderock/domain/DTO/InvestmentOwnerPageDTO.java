package com.project.Coderock.domain.DTO;

public class InvestmentOwnerPageDTO {
    private String investment_id;
    private String owner_id;
    private String create_date;
    private Double investment;
    private Double amount;
    private String status;

    public InvestmentOwnerPageDTO() {
    }

    public InvestmentOwnerPageDTO(String investment_id, String owner_id, String create_date, Double investment, Double amount, String status) {
        this.investment_id = investment_id;
        this.owner_id = owner_id;
        this.create_date = create_date;
        this.investment = investment;
        this.amount = amount;
        this.status = status;
    }

    public String getInvestment_id() {
        return investment_id;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public String getCreate_date() {
        return create_date;
    }

    public Double getInvestment() {
        return investment;
    }

    public Double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

}
