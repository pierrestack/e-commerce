package com.ecommerce.services.user;

import com.ecommerce.dto.user.UserRequestDTO;
import com.ecommerce.dto.user.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO create(UserRequestDTO dto);

    List<UserResponseDTO> getAll();

    UserResponseDTO getById(Long id);

    UserResponseDTO update(Long id, UserRequestDTO dto);

    void delete(Long id);
}
