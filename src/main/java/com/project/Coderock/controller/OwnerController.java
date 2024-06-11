package com.project.Coderock.controller;

import com.project.Coderock.application.usecases.CreateOwner;
import com.project.Coderock.domain.DTO.CreateOwnerDTO;
import com.project.Coderock.domain.HandlersService.HandlerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("owner")
public class OwnerController {
    private CreateOwner createOwner;
    public OwnerController(CreateOwner createOwner){
        this.createOwner = createOwner;
    }

    @PostMapping("")
    public ResponseEntity<HandlerDTO> save(@RequestBody  CreateOwnerDTO ownerDTO){
        HandlerDTO output = this.createOwner.execute(ownerDTO);
        return new ResponseEntity<>(output, output.status());
    }
}
