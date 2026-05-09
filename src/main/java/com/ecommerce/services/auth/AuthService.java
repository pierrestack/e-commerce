package com.ecommerce.services.auth;

import com.ecommerce.dto.auth.AuthRefreshTokenRequestDTO;
import com.ecommerce.dto.auth.AuthRequestDTO;
import com.ecommerce.dto.auth.AuthResponseDTO;
import com.ecommerce.entities.User;
import com.ecommerce.repositories.UserRepository;
import com.ecommerce.services.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthResponseDTO login(AuthRequestDTO request) {

        User user = userRepository.findByEmail(request.email())
                .orElseThrow();

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        return new AuthResponseDTO(accessToken, refreshToken);
    }

    public AuthResponseDTO refreshToken(AuthRefreshTokenRequestDTO request) {

        String username = jwtService.extractUsername(request.refreshToken());

        User user = userRepository.findByUsername(username)
                .orElseThrow();

        if (!jwtService.isTokenValid(request.refreshToken())) {
            throw new RuntimeException("Invalid refresh token");
        }

        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        return new AuthResponseDTO(accessToken, refreshToken);
    }
}
