package com.br.budgetbuddy.security.service;

import com.br.budgetbuddy.user.service.UserServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    private final UserServiceImpl userService;

    public AuthorizationService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.findByUsername(username);
    }
}
