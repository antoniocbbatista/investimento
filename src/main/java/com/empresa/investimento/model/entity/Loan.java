package com.empresa.investimento.model.entity;

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
    @GeneratedValue(strategy = GenerationType.AUTO)  // Use AUTO em vez de UUID
    private UUID id;

    private Double requestAmount;

    private Double interestRate;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    @Getter
    private LocalDate startDate;

    private int term;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getTerm() {
        return term;
    }

    public Double getRequestAmount(){
        return requestAmount;
    }
}
