package com.kolu.jobappbackend.user.model;

public record LoginRequest(
        String email,
        String password
) {
}
