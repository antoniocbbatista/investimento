package com.empresa.investimento.services;

import com.empresa.investimento.model.dto.LoanCalculationResultDTO;
import com.empresa.investimento.model.entity.Loan;
import com.empresa.investimento.model.entity.LoanStatus;
import com.empresa.investimento.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public List<Loan>  getLoansByUserId(UUID userId){
        return loanRepository.findByUser_Id(userId);
    }

    public Loan updateLoanStatus(UUID loanId, LoanStatus status){
        Optional<Loan> loanOptional = loanRepository.findById(loanId);
        if (loanOptional.isEmpty()) {
            throw new RuntimeException("Empréstimo nao encontrado");
        }
        Loan loan = loanOptional.get();
        loan.setStatus(status);
        return loanRepository.save(loan);
    }

    public LocalDate calculateDueTerm(Loan loan){
        return loan.getStartDate().plusMonths(loan.getTerm());
    }

    public Loan calculateTotalWithInterest(Loan loan){
        double monthlyRate = loan.getMonthlyInterestRate();
        loan.setTotalAmount(loan.getRequestAmount() * Math.pow(1 + monthlyRate, loan.getTermInMonths()));
        return loan;
    }

    public Double calculateMonthlyInstallment(double totalWithInterest, int months){
        return totalWithInterest / months;
    }

    public LoanCalculationResultDTO loanCalculationResultDTO(Loan loan) {
        double totalWithInterest = calculateTotalWithInterest(loan).getTotalAmount();
        double monthlyInstallment = calculateMonthlyInstallment(totalWithInterest, loan.getTermInMonths());

        return new LoanCalculationResultDTO(
                loan.getUser(),
                totalWithInterest,
                monthlyInstallment,
                loan.getTermInMonths()
        );
    }
}
