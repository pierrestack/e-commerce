package com.ecommerce.auth.controller;

import com.ecommerce.auth.dto.AuthRefreshTokenRequestDTO;
import com.ecommerce.auth.dto.AuthRequestDTO;
import com.ecommerce.auth.dto.AuthResponseDTO;
import com.ecommerce.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
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
