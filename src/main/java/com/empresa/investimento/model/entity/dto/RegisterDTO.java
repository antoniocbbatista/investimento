package com.empresa.investimento.model.entity.dto;

import com.empresa.investimento.model.entity.UserRole;

public record RegisterDTO(String login, String password, String email, UserRole role) {
}
