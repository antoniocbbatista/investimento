package com.empresa.investimento.controller;


import com.empresa.investimento.model.dto.LoanCalculationResultDTO;
import com.empresa.investimento.model.entity.Loan;
import com.empresa.investimento.repository.LoanRepository;
import com.empresa.investimento.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private LoanService loanService;

    @PostMapping("calculate")
    public ResponseEntity<LoanCalculationResultDTO> calculateLoan(@RequestBody Loan loan){
        LoanCalculationResultDTO result = loanService.loanCalculationResultDTO(loan);
        loanRepository.save(loan);
        return ResponseEntity.ok(result);
    }
}
