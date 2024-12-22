package com.empresa.investimento.services;

import com.empresa.investimento.model.entity.Loan;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LoanService {

    public LocalDate calculateDueTerm(Loan loan){
        return loan.getStartDate().plusMonths(loan.getTerm());
    }
}
