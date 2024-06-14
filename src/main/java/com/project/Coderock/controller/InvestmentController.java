package com.project.Coderock.controller;

import com.project.Coderock.application.usecases.CreateInvestment;
import com.project.Coderock.application.usecases.ViewInvestment;
import com.project.Coderock.application.usecases.WithdrawalInvestment;
import com.project.Coderock.domain.DTO.CreateInvestmentDTO;
import com.project.Coderock.domain.DTO.WithdrawalInvestimentDTO;
import com.project.Coderock.domain.HandlersService.HandlerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("investment")
public class InvestmentController {
    private CreateInvestment createInvestment;
    private ViewInvestment viewInvestment;
    protected WithdrawalInvestment withdrawalInvestment;

    public InvestmentController(CreateInvestment createInvestment, ViewInvestment viewInvestment, WithdrawalInvestment withdrawalInvestment) {
        this.createInvestment = createInvestment;
        this.viewInvestment = viewInvestment;
        this.withdrawalInvestment = withdrawalInvestment;
    }

    @PostMapping
    public ResponseEntity<HandlerDTO> save(@RequestBody CreateInvestmentDTO createInvestmentDTO) {
        HandlerDTO output = this.createInvestment.execute(createInvestmentDTO);
        return new ResponseEntity<>(output, output.status());
    }

    @GetMapping(value = "{id}/view")
    public ResponseEntity<HandlerDTO> view(@PathVariable String id) {
        HandlerDTO output = this.viewInvestment.execute(id);
        return new ResponseEntity<>(output, output.status());
    }

    @PostMapping(value = "{id}/withdrawal")
    public ResponseEntity<HandlerDTO> withdrawal(@PathVariable String id, @RequestBody WithdrawalInvestimentDTO withdrawalInvestimentDTO) {
        HandlerDTO output = this.withdrawalInvestment.exceute(id, withdrawalInvestimentDTO.withdrawal_date());
        return new ResponseEntity<>(output, output.status());
    }
}
