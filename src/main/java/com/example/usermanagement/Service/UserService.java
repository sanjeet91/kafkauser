package com.example.usermanagement.Service;

import com.example.usermanagement.dto.RegisterRequest;
import com.example.usermanagement.Model.Role;
import com.example.usermanagement.Model.User;
import com.example.usermanagement.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserService {
@Autowired
    private  UserRepository userRepository;
@Autowired(required = true)
    private  PasswordEncoder passwordEncoder;

    public User register(@org.jetbrains.annotations.NotNull RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
