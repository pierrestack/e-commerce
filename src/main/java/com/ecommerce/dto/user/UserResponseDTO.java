package com.ecommerce.dto.user;

import com.ecommerce.enums.Role;

import java.time.LocalDateTime;

public record UserResponseDTO(
        Long id,
        String username,
        String email,
        Role role,
        LocalDateTime createdAt
) {
}
