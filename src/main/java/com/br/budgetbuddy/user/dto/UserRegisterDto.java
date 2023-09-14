package com.br.budgetbuddy.user.dto;


import jakarta.validation.constraints.NotBlank;

public record UserRegisterDto(
        @NotBlank(message = "O username precisa ser informado") String username,
        @NotBlank(message = "A senha precisa ser informada") String password,
        @NotBlank(message = "O email precisa ser informado") String email) {
}
