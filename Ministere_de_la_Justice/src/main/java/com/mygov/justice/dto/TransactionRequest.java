package com.mygov.justice.dto;

public record TransactionRequest(
        String nom,
        String description,
        String ministere) {
}
