package com.example.usermanagement.Controller;

import com.example.usermanagement.dto.RegisterRequest;
import com.example.usermanagement.Model.User;
import com.example.usermanagement.Service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private  UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        User saved = userService.register(request);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
