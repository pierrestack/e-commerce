package com.ecommerce.user.service;

import com.ecommerce.user.dto.UserRequestDTO;
import com.ecommerce.user.dto.UserResponseDTO;
import java.util.List;

public interface UserService {
  UserResponseDTO create(UserRequestDTO dto);

  List<UserResponseDTO> getAll();

  UserResponseDTO getById(Long id);

  UserResponseDTO update(Long id, UserRequestDTO dto);

  void delete(Long id);
}
