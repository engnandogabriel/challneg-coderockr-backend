package com.project.Coderock.application.DAO;

import com.project.Coderock.domain.DTO.InvestmentOwnerPageDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InvestmentDAO {
    Page<InvestmentOwnerPageDTO> pagination(String owenr_id, int page, int size);
}
