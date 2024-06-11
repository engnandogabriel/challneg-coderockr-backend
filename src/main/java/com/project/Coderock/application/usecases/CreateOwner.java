package com.project.Coderock.application.usecases;

import com.project.Coderock.application.repository.OwnerRepository;
import com.project.Coderock.domain.DTO.CreateOwnerDTO;
import com.project.Coderock.domain.entites.Owner;
import org.springframework.stereotype.Service;

@Service
public class CreateOwner {
    private OwnerRepository ownerRepository;

    public CreateOwner(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public void execute(CreateOwnerDTO ownerDTO) {
        try {
            System.out.println(ownerDTO);
            Owner owner = Owner.create(ownerDTO.name(), ownerDTO.email());
            ownerRepository.save(owner);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
