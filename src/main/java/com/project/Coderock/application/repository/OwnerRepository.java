package com.project.Coderock.application.repository;

import com.project.Coderock.domain.entites.Owner;
import com.project.Coderock.infra.model.OwnerJPA;

import java.util.Optional;

public interface OwnerRepository {
    void save(Owner owner);
    Optional<Owner> getByEmail(String email);
}
