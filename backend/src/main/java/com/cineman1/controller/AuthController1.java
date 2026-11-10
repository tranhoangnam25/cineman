package com.cineman1.controller;

import com.cineman1.dto.LoginRequest1;
import com.cineman1.dto.LoginResponse1;
import com.cineman1.service.AuthService1;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController1 {

    private final AuthService1 authService1;

    public AuthController1(AuthService1 authService1) {
        this.authService1 = authService1;
    }

    @PostMapping("/login1")
    public ResponseEntity<LoginResponse1> dangNhap(@RequestBody LoginRequest1 request) {
        return ResponseEntity.ok(authService1.dangNhap(request));
    }
}
