package com.project.Coderock.application.usecases;

import com.project.Coderock.application.repository.InvestmentRepository;
import com.project.Coderock.domain.Exceptions.NotFoundError;
import com.project.Coderock.domain.HandlersService.HandlerDTO;
import com.project.Coderock.domain.HandlersService.Handlers;
import com.project.Coderock.domain.entites.Investment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ViewInvestment {
    private InvestmentRepository investmentRepository;

    public ViewInvestment(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    public HandlerDTO execute(String investment_id) {
        try {
            Optional<Investment> investment = this.investmentRepository.getById(investment_id);
            System.out.println(investment);
            if (investment.isEmpty()) new Handlers<>().badRquest(new NotFoundError("Investment not found"));
            if (investment.get().getStatus().equals("withdrawn")) return new Handlers<>().success(investment);
            investment.get().viewBalanceInvestment();
            return new Handlers<>().success(investment);
        } catch (RuntimeException e) {
            return new Handlers<>().servrError(e);
        } catch (Exception e) {
            return new Handlers<>().badRquest(e);
        }
    }
}
