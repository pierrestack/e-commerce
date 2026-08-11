package com.ecommerce.user.dto;

import com.ecommerce.user.enums.Role;

import java.time.LocalDateTime;

public record UserResponseDTO(
        Long id,
        String username,
        String email,
        Role role,
        LocalDateTime createdAt
) {
}
