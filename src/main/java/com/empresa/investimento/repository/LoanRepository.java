package com.empresa.investimento.repository;

import com.empresa.investimento.model.entity.Loan;
import com.empresa.investimento.model.entity.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LoanRepository extends JpaRepository<Loan, UUID> {

    List<Loan> findByUser_Id(UUID userId);

    List<Loan> findByStatus(LoanStatus status);
}
