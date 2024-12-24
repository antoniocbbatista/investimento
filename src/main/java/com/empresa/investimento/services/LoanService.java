package com.empresa.investimento.services;

import com.empresa.investimento.model.entity.Loan;
import com.empresa.investimento.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public Loan createLoan(Loan loan){
        if (loan.getRequestAmount() <= 0){
            throw new IllegalArgumentException("O valor precisa ser maior que 0");
        }
        return loanRepository.save(loan);
    }

    public LocalDate calculateDueTerm(Loan loan){
        return loan.getStartDate().plusMonths(loan.getTerm());
    }
}
