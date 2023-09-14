package com.br.budgetbuddy.security.service;

import com.br.budgetbuddy.security.dto.AuthenticationCredentialsDto;
import com.br.budgetbuddy.security.dto.LoginResponseDTO;
import com.br.budgetbuddy.user.dto.UserRegisterDto;
import com.br.budgetbuddy.user.entity.User;
import com.br.budgetbuddy.user.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthenticationService {


    private final UserServiceImpl userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public LoginResponseDTO login(AuthenticationCredentialsDto data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return new LoginResponseDTO(token);
    }

    public UUID register(@RequestBody @Valid UserRegisterDto registerDto) {
        return userService.register(registerDto);
    }
}
