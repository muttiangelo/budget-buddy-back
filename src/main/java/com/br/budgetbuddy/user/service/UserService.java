package com.br.budgetbuddy.user.service;

import com.br.budgetbuddy.user.dto.UserRegisterDto;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserService {

    UserDetails findByUsername(@NotBlank String username);

    UUID register(UserRegisterDto user);
}
