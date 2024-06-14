package com.project.Coderock.application.usecases;

import com.project.Coderock.application.DAO.InvestmentDAO;
import com.project.Coderock.domain.DTO.InvestmentOwnerPageDTO;
import com.project.Coderock.domain.DTO.PageResponseDTO;
import com.project.Coderock.domain.HandlersService.HandlerDTO;
import com.project.Coderock.domain.HandlersService.Handlers;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetOwnerInvestments {
    private InvestmentDAO investmentDAO;

    public GetOwnerInvestments(InvestmentDAO investmentDAO) {
        this.investmentDAO = investmentDAO;
    }

    public HandlerDTO execute(String owner_id, int page, int size) {
        try {
            Page<InvestmentOwnerPageDTO> investmentOwnerPageDTO = this.investmentDAO.pagination(owner_id, page, size);
            PageResponseDTO pageResponseDTO = new PageResponseDTO<>();
            pageResponseDTO.setContent(investmentOwnerPageDTO.getContent());;
            pageResponseDTO.setTotalPages(investmentOwnerPageDTO.getTotalPages());
            pageResponseDTO.setTotalElements(investmentOwnerPageDTO.getTotalElements());
            pageResponseDTO.setSize(investmentOwnerPageDTO.getSize());
            return new Handlers<>().success(pageResponseDTO);
        } catch (RuntimeException e) {
            return new Handlers<>().servrError(e);
        }
    }
}
