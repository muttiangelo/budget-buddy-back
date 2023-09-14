package com.br.budgetbuddy.user.enums;

import lombok.Getter;

@Getter
public enum UserRole {

    CONVENTIONAL(1, "Conventional"),
    PREMIUM(2, "PREMIUM");

    private final int id;
    private final String description;

    UserRole(int id, String description) {
        this.id = id;
        this.description = description;
    }
}
