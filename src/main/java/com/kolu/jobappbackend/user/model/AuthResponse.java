package com.kolu.jobappbackend.user.model;

public record AuthResponse(
        String token,
        String validTill
) { }
