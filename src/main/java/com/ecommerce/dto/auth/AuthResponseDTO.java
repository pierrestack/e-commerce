package com.ecommerce.dto.auth;

public record AuthResponseDTO(
        String accessToken,
        String refreshToken
) {
}
