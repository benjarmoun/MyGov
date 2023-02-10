package com.mygov.finance.dto;

public record TransactionRequest(
        String nom,
        String description,
        String ministere) {
}
