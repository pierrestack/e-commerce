package com.ecommerce.controllers;

import com.ecommerce.dto.auth.AuthRefreshTokenRequestDTO;
import com.ecommerce.dto.auth.AuthRequestDTO;
import com.ecommerce.dto.auth.AuthResponseDTO;
import com.ecommerce.services.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody AuthRequestDTO request) {
        return authService.login(request);
    }

    @PostMapping("/refresh-token")
    public AuthResponseDTO refreshToken(@RequestBody AuthRefreshTokenRequestDTO request) {
        return authService.refreshToken(request);
    }
}
