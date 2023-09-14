package com.br.budgetbuddy.security.dto;

public record AuthenticationCredentialsDto(
        String username,
        String password
) {
}
