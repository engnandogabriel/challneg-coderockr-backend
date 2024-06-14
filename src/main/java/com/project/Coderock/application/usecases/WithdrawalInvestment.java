package com.project.Coderock.application.usecases;
import com.project.Coderock.application.repository.InvestmentRepository;
import com.project.Coderock.domain.Exceptions.NotFoundError;
import com.project.Coderock.domain.HandlersService.HandlerDTO;
import com.project.Coderock.domain.HandlersService.Handlers;
import com.project.Coderock.domain.entites.Investment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WithdrawalInvestment {
    private InvestmentRepository investmentRepository;

    public WithdrawalInvestment(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    public HandlerDTO exceute(String investment_id, String withdrawal_date) {
        try {
            Optional<Investment> investment = this.investmentRepository.getById(investment_id);
            if (investment.isEmpty()) return new Handlers<>().notFound(new NotFoundError("Investment not found"));
            if(investment.get().getStatus().equals("withdrawn")) return new Handlers<>().badRquest(new Exception("Not authorized"));
            investment.get().calculateBalance(withdrawal_date);
            investment.get().setWithdrawn();
            this.investmentRepository.update(investment.get());
            return new Handlers<>().success(investment.get());
        } catch (RuntimeException e) {
            return new Handlers<>().servrError(e);
        } catch (Exception e) {
            return new Handlers<>().badRquest(e);
        }
    }
}
