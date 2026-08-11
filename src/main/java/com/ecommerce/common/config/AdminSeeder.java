package com.ecommerce.common.config;

import com.ecommerce.user.entity.User;
import com.ecommerce.user.enums.Role;
import com.ecommerce.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminSeeder implements CommandLineRunner {

  private final UserRepository userRepository;

  private final PasswordEncoder passwordEncoder;

  @Value("${admin.username}")
  private String username;

  @Value("${admin.email}")
  private String email;

  @Value("${admin.password}")
  private String password;

  @Override
  public void run(String... args) {

    if (!userRepository.existsByUsername(username)) {

      User admin = new User();

      admin.setUsername(username);

      admin.setEmail(email);

      admin.setPassword(passwordEncoder.encode(password));

      admin.setRole(Role.ADMIN);

      userRepository.save(admin);
    }
  }
}
