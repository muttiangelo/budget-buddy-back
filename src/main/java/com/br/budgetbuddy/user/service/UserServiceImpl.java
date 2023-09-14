package com.br.budgetbuddy.user.service;

import com.br.budgetbuddy.user.dto.UserRegisterDto;
import com.br.budgetbuddy.user.entity.User;
import com.br.budgetbuddy.user.enums.UserRole;
import com.br.budgetbuddy.user.repository.UserRepository;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserDetails findByUsername(@Validated @NotBlank String username) {
        return repository.findByUsername(username);
    }

    public UUID register(@Validated UserRegisterDto userRegisterDto) {
        return repository.save(new User(userRegisterDto.username(),
                new BCryptPasswordEncoder().encode(userRegisterDto.password()),
                userRegisterDto.email(), UserRole.CONVENTIONAL)).getId();
    }
}
