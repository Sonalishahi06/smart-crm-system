package com.crm.backend.controller;

import com.crm.backend.dto.ChangePasswordRequest;
import com.crm.backend.dto.LoginRequest;
import com.crm.backend.dto.RegisterRequest;
import com.crm.backend.entity.User;
import com.crm.backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@Valid @RequestBody RegisterRequest request){
        return userService.registerUser(request);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest request) {
        return userService.loginUser(request.getEmail(), request.getPassword());
    }

    @PutMapping("/change-password")
    public String changePassword(@Valid @RequestBody ChangePasswordRequest request){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        String email= auth.getName();
        return userService.changePassword(email, request.getOldPassword(), request.getNewPassword(),request.getConfirmPassword());
    }
}
