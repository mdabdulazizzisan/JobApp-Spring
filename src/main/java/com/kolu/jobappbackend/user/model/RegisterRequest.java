package com.kolu.jobappbackend.user.model;

public record RegisterRequest(
        String firstname,
        String lastname,
        String email,
        String password
) {}