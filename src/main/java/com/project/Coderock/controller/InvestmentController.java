package com.project.Coderock.controller;

import com.project.Coderock.application.usecases.CreateInvestment;
import com.project.Coderock.domain.DTO.CreateInvestmentDTO;
import com.project.Coderock.domain.HandlersService.HandlerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("investment")
public class InvestmentController {
    private CreateInvestment createInvestment;

    public InvestmentController(CreateInvestment createInvestment){
        this.createInvestment = createInvestment;
    }

    @PostMapping
    public ResponseEntity<HandlerDTO> save(@RequestBody CreateInvestmentDTO createInvestmentDTO){
        HandlerDTO output = this.createInvestment.execute(createInvestmentDTO);
        return new ResponseEntity<>(output, output.status());
    }
}
