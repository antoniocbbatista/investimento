package com.empresa.investimento.model.dto;

import com.empresa.investimento.model.entity.UserRole;

public record RegisterDTO(String login, String password, String email, String cpf, String address, String phone, String role) {
}
