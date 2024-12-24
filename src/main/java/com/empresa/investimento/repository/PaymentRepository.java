package com.empresa.investimento.repository;

import com.empresa.investimento.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByLoanId(Long loanId);

    // Exemplo: Encontrar pagamentos por data de pagamento
    List<Payment> findByDatePaymentBetween(LocalDate startDate, LocalDate endDate);
}