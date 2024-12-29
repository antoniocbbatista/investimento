package com.empresa.investimento.model.dto;

public record RegisterDTO(String login, String password, String email, String cpf, String address, String phone, String role) {
}
