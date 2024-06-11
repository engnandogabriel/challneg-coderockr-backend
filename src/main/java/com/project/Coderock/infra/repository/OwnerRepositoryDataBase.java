package com.project.Coderock.infra.repository;

import com.project.Coderock.application.repository.OwnerRepository;
import com.project.Coderock.domain.entites.Owner;
import com.project.Coderock.infra.model.OwnerJPA;
import com.project.Coderock.infra.model.OwnerModel;
import org.springframework.stereotype.Repository;

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
}
