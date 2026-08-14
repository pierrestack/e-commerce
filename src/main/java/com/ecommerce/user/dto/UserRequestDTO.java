package com.ecommerce.user.dto;

import com.ecommerce.user.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(
    @NotBlank(message = "Username is required") String username,
    @Email(message = "Invalid email") String email,
    @NotBlank(message = "Password is required") String password,
    Role role) {}
