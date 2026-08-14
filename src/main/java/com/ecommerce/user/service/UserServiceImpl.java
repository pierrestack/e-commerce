package com.ecommerce.user.service;

import com.ecommerce.common.exception.DuplicateResourceException;
import com.ecommerce.common.exception.ResourceNotFoundException;
import com.ecommerce.user.dto.UserRequestDTO;
import com.ecommerce.user.dto.UserResponseDTO;
import com.ecommerce.user.entity.User;
import com.ecommerce.user.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public UserResponseDTO create(UserRequestDTO dto) {

    if (userRepository.existsByEmail(dto.email())) {
      throw new DuplicateResourceException("Email already exists");
    }

    if (userRepository.existsByUsername(dto.username())) {
      throw new DuplicateResourceException("Username already exists");
    }

    User user =
        User.builder()
            .username(dto.username())
            .email(dto.email())
            .password(passwordEncoder.encode(dto.password()))
            .role(dto.role())
            .build();

    User saved = userRepository.save(user);

    return mapToDTO(saved);
  }

  @Override
  public List<UserResponseDTO> getAll() {

    return userRepository.findAll().stream().map(this::mapToDTO).toList();
  }

  @Override
  public UserResponseDTO getById(Long id) {

    User user =
        userRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

    return mapToDTO(user);
  }

  @Override
  public UserResponseDTO update(Long id, UserRequestDTO dto) {

    User user =
        userRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

    user.setUsername(dto.username());
    user.setEmail(dto.email());
    user.setPassword(passwordEncoder.encode(dto.password()));
    user.setRole(dto.role());

    User updated = userRepository.save(user);

    return mapToDTO(updated);
  }

  @Override
  public void delete(Long id) {

    User user =
        userRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

    userRepository.delete(user);
  }

  private UserResponseDTO mapToDTO(User user) {

    return new UserResponseDTO(
        user.getId(), user.getUsername(), user.getEmail(), user.getRole(), user.getCreatedAt());
  }
}
