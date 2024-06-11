package com.project.Coderock.infra.repository;

import com.project.Coderock.application.repository.OwnerRepository;
import com.project.Coderock.domain.entites.Owner;
import com.project.Coderock.infra.model.OwnerJPA;
import com.project.Coderock.infra.model.OwnerModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class OwnerRepositoryDataBase implements OwnerRepository {
    private OwnerJPA ownerJPA;

    public OwnerRepositoryDataBase(OwnerJPA ownerJPA) {
        this.ownerJPA = ownerJPA;
    }

    @Override
    public void save(Owner owner) {
        OwnerModel ownerJPA = new OwnerModel(owner.getOwner_id(), owner.getName(), owner.getEmail());
        this.ownerJPA.save(ownerJPA);
    }

    @Override
    public Optional<Owner> getByEmail(String email) {
        OwnerModel ownerModel = this.ownerJPA.findByEmail(email).orElse(null);
        if (ownerModel == null) return Optional.empty();
        Owner owner = Owner.restore(ownerModel.getOwner_id(), ownerModel.getName(), ownerModel.getEmail());
        return Optional.of(owner);
    }

    @Override
    public Optional<Owner> getById(String id) {
        OwnerModel ownerModel = this.ownerJPA.findByEmail(id).orElse(null);
        if (ownerModel == null) return Optional.empty();
        Owner owner = Owner.restore(ownerModel.getOwner_id(), ownerModel.getName(), ownerModel.getEmail());
        return Optional.of(owner);
    }
}
