package com.kolu.jobappbackend.user.service;

import com.kolu.jobappbackend.user.JwtService;
import com.kolu.jobappbackend.user.model.AuthResponse;
import com.kolu.jobappbackend.user.model.LoginRequest;
import com.kolu.jobappbackend.user.model.RegisterRequest;
import com.kolu.jobappbackend.user.model.Roles;
import com.kolu.jobappbackend.user.model.User;
import com.kolu.jobappbackend.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;

    public AuthResponse registerUser(
            RegisterRequest request,
            Roles role
    ) {
        var user = userRepo.findByEmail(request.email());

        if (user.isPresent()) {
            throw new IllegalStateException("User already exists");
        }

        userRepo.save(
                User
                        .builder()
                        .firstname(request.firstname())
                        .lastname(request.lastname())
                        .email(request.email())
                        .password(passwordEncoder.encode(request.password()))
                        .role(role)
                        .build()
        );

        String token = jwtService.generateToken(request.email());
        System.out.println(token);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String expiration = dateFormat.format(jwtService.extractExpiration(token));
        System.out.println(expiration);
        return new AuthResponse(
                token,
                expiration
        );
    }

    public AuthResponse loginUser(LoginRequest request) {
        var user = userRepo.findByEmail(request.email());
        if (user.isEmpty()) {
            throw new IllegalStateException("User not found");
        }
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        String token = jwtService.generateToken(request.email());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String expiration = dateFormat.format(jwtService.extractExpiration(token));
        return new AuthResponse(
                token,
                expiration
        );
    }
}
