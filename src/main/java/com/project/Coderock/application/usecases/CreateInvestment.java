package com.project.Coderock.application.usecases;

import com.project.Coderock.application.repository.InvestmentRepository;
import com.project.Coderock.application.repository.OwnerRepository;
import com.project.Coderock.domain.DTO.CreateInvestmentDTO;
import com.project.Coderock.domain.Exceptions.NotFoundError;
import com.project.Coderock.domain.HandlersService.HandlerDTO;
import com.project.Coderock.domain.HandlersService.Handlers;
import com.project.Coderock.domain.entites.Investment;
import com.project.Coderock.domain.entites.Owner;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
public class CreateInvestment {

    private InvestmentRepository investmentRepository;
    private OwnerRepository ownerRepository;

    public CreateInvestment(InvestmentRepository investmentRepository, OwnerRepository ownerRepository) {
        this.investmentRepository = investmentRepository;
        this.ownerRepository = ownerRepository;
    }

    public HandlerDTO execute(CreateInvestmentDTO investmentDTO) {
        try {
            Optional<Owner> owner = this.ownerRepository.getById(investmentDTO.owner_id());
            if (owner.isEmpty()) return new Handlers<>().notFound(new NotFoundError("Owner not found"));
            Investment investment = Investment.create(investmentDTO.owner_id(), investmentDTO.create_date(), investmentDTO.amount());
            this.investmentRepository.save(investment);
            return new Handlers<>().success(investment);
        } catch (RuntimeException e) {
            return new Handlers<>().servrError(e);
        } catch (Exception e) {
            return new Handlers<>().badRquest(e);
        }
    }
}
