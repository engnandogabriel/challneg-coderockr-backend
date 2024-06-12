package com.project.Coderock.infra.repository;

import com.project.Coderock.application.repository.InvestmentRepository;
import com.project.Coderock.domain.entites.Investment;
import com.project.Coderock.infra.model.InvestmentJPA;
import com.project.Coderock.infra.model.InvestmentModel;
import org.springframework.stereotype.Repository;

@Repository
public class InvestmentRepositoryDatabase implements InvestmentRepository {
    private InvestmentJPA investmentJPA;

    public InvestmentRepositoryDatabase(InvestmentJPA investmentJPA) {
        this.investmentJPA = investmentJPA;
    }

    @Override
    public void save(Investment investment) {
        InvestmentModel investmentModel = new InvestmentModel(investment.getInvestment_id(), investment.getOwner_id(), investment.getCreate_date(), investment.getAmount(), investment.getStatus());
        this.investmentJPA.save(investmentModel);
    }
}
