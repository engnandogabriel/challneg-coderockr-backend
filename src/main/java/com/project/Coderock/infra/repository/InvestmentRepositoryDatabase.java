package com.project.Coderock.infra.repository;

import com.project.Coderock.application.repository.InvestmentRepository;
import com.project.Coderock.domain.entites.Investment;
import com.project.Coderock.infra.model.InvestmentJPA;
import com.project.Coderock.infra.model.InvestmentModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InvestmentRepositoryDatabase implements InvestmentRepository {
    private InvestmentJPA investmentJPA;

    public InvestmentRepositoryDatabase(InvestmentJPA investmentJPA) {
        this.investmentJPA = investmentJPA;
    }

    @Override
    public void save(Investment investment) {
        InvestmentModel investmentModel = new InvestmentModel(investment.getInvestment_id(), investment.getOwner_id(), investment.getCreate_date(), investment.getInvestment(), investment.getAmount(), investment.getStatus());
        this.investmentJPA.save(investmentModel);
    }

    @Override
    public Optional<Investment> getById(String investment_id) throws Exception {
        InvestmentModel investmentModel = this.investmentJPA.findById(investment_id).orElse(null);
        if (investment_id == null) return Optional.empty();
        Investment investment = Investment.restore(investmentModel.getInvestment_id(), investmentModel.getOwner_id(), investmentModel.getCreate_date(), investmentModel.getInvestment(), investmentModel.getAmount(), investmentModel.getStatus());
        return Optional.of(investment);
    }
}
