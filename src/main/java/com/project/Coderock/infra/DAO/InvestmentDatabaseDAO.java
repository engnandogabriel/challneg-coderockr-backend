package com.project.Coderock.infra.DAO;

import com.project.Coderock.application.DAO.InvestmentDAO;
import com.project.Coderock.domain.DTO.InvestmentOwnerPageDTO;
import com.project.Coderock.infra.model.InvestmentJPA;
import com.project.Coderock.infra.model.InvestmentModel;
import com.project.Coderock.infra.model.OwnerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InvestmentDatabaseDAO implements InvestmentDAO {

    private final InvestmentJPA investmentJPA;

    @Autowired
    public InvestmentDatabaseDAO(InvestmentJPA investmentJPA) {
        this.investmentJPA = investmentJPA;
    }

    @Override
    public Page<InvestmentOwnerPageDTO> pagination(String owner_id, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        OwnerModel ownerModel = new OwnerModel(owner_id);
        Page<InvestmentModel> investmentModelsPage = this.investmentJPA.findByOwnerId(ownerModel, pageable);

        List<InvestmentOwnerPageDTO> investmentOwnerPageDTOs = investmentModelsPage.getContent().stream()
                .map(investment -> new InvestmentOwnerPageDTO(
                        investment.getInvestmentId(),
                        investment.getOwnerId().getOwner_id(),
                        investment.getCreateDate().toString(),
                        investment.getInvestment(),
                        investment.getAmount(),
                        investment.getStatus()))
                .collect(Collectors.toList());

        return new PageImpl<>(investmentOwnerPageDTOs, pageable, investmentModelsPage.getTotalElements());
    }
}
