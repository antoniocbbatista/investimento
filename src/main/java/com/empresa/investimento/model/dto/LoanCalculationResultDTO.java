package com.empresa.investimento.model.dto;

import com.empresa.investimento.model.entity.User;

public record LoanCalculationResultDTO(User user, double totalWithInterest, double monthlyInstallment, int months) {
}
