package com.project.Coderock.application.repository;

import com.project.Coderock.domain.entites.Investment;

import java.util.Optional;

public interface InvestmentRepository {
    void save(Investment investment);
    Optional<Investment> getById(String investment_id) throws Exception;
}
