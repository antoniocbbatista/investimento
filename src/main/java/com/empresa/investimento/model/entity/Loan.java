package com.empresa.investimento.model.entity;

import com.empresa.investimento.services.LoanService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "loan")
@Table(name = "loan")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Double requestAmount;

    private Double TotalAmount;

    private Double monthlyInterestRate;

    private Double annualInterestRate;

    private Double totalInterest;

    private Integer termInMonths;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    @Getter
    private LocalDate startDate;

    private int term;

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Double getRequestAmount() {
        return requestAmount;
    }

    public Double getTotalAmount() {
        return TotalAmount;
    }

    public Double getMonthlyInterestRate() {
        return monthlyInterestRate;
    }

    public Double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public Double getTotalInterest() {
        return totalInterest;
    }

    public Integer getTermInMonths() {
        return termInMonths;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getTerm() {
        return term;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRequestAmount(Double requestAmount) {
        this.requestAmount = requestAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        TotalAmount = totalAmount;
    }

    public void setMonthlyInterestRate(Double monthlyInterestRate) {
        this.monthlyInterestRate = monthlyInterestRate;
    }

    public void setAnnualInterestRate(Double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setTotalInterest(Double totalInterest) {
        this.totalInterest = totalInterest;
    }

    public void setTermInMonths(Integer termInMonths) {
        this.termInMonths = termInMonths;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setTerm(int term) {
        this.term = term;
    }
}
