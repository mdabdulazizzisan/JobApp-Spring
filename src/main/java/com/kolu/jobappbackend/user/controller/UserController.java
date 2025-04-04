package com.kolu.jobappbackend.user.controller;

import com.kolu.jobappbackend.user.model.AuthResponse;
import com.kolu.jobappbackend.user.model.LoginRequest;
import com.kolu.jobappbackend.user.model.RegisterRequest;
import com.kolu.jobappbackend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("auth/user/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody
            LoginRequest request
    ) {
        return ResponseEntity.ok( userService.loginUser(request));
    }

    @PostMapping("auth/user/register")
    public ResponseEntity<AuthResponse> registerUser(
            @RequestBody
            RegisterRequest request
    ) {
        return ResponseEntity.ok(userService.registerUser(request));
    }


}
