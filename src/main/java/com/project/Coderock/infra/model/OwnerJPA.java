package com.project.Coderock.infra.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerJPA extends JpaRepository<OwnerModel, String> {

    Optional<OwnerModel> findByEmail(String email);
}
