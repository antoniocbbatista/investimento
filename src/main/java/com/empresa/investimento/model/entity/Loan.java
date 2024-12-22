package com.empresa.investimento.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "loan")
@Table(name = "loan")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double requestAmount;

    private Double interestRate;

    private LoanStatus status;

    @Getter
    private LocalDate startDate;

    private int term;

    @ManyToOne
    private User user;

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getTerm() {
        return term;
    }
}
