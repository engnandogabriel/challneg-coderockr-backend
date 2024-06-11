package com.project.Coderock.application.usecases;

import com.project.Coderock.application.repository.OwnerRepository;
import com.project.Coderock.domain.DTO.CreateOwnerDTO;
import com.project.Coderock.domain.HandlersService.HandlerDTO;
import com.project.Coderock.domain.HandlersService.Handlers;
import com.project.Coderock.domain.entites.Owner;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateOwner {
    private OwnerRepository ownerRepository;

    public CreateOwner(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public HandlerDTO execute(CreateOwnerDTO ownerDTO) {
        try {
            Optional<Owner> ownerExits = this.ownerRepository.getByEmail(ownerDTO.email());
            if (ownerExits.isPresent()) return new Handlers<>().badRquest(new Exception("User already exists"));

            Owner owner = Owner.create(ownerDTO.name(), ownerDTO.email());
            ownerRepository.save(owner);
            return new Handlers<>().success(owner);

        } catch (RuntimeException e) {
            return new Handlers<>().servrError(e);
        } catch (Exception e) {
            return new Handlers<>().badRquest(e);
        }
    }
}
