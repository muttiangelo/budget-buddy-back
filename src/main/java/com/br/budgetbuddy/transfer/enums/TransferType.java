package com.br.budgetbuddy.transfer.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
//TODO AM: 2021-09-05 - Add an actual icon to the transfer type
public enum TransferType {

    INCOME(1, "Income", "fas fa-hand-holding-usd"),
    EXPENSE(2, "Expense", "fas fa-hand-holding-usd"),
    TRANSFER(3, "Transfer", "fas fa-hand-holding-usd"),
    INVESTMENT(4, "Investment", "fas fa-hand-holding-usd");

    private final int id;
    private final String description;
    private final String icon;
}
