package com.project.Coderock.infra.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestmentJPA extends JpaRepository<InvestmentModel, String> {
    Page<InvestmentModel> findByOwnerId(OwnerModel ownerId, Pageable pageable);
}
