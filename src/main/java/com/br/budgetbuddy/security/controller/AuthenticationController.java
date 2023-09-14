package com.br.budgetbuddy.security.controller;

import com.br.budgetbuddy.security.dto.AuthenticationCredentialsDto;
import com.br.budgetbuddy.security.dto.LoginResponseDTO;
import com.br.budgetbuddy.security.service.AuthenticationService;
import com.br.budgetbuddy.user.dto.UserRegisterDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationCredentialsDto data) {
        return ResponseEntity.ok(authenticationService.login(data));
    }


    @PostMapping("register")
    public ResponseEntity<UUID> register(@RequestBody @Valid UserRegisterDto data) {
        return ResponseEntity.ok(authenticationService.register(data));
    }
}
