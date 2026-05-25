package com.crm.backend.controller;

import com.crm.backend.dto.LoginRequest;
import com.crm.backend.entity.User;
import com.crm.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUSer(@RequestBody User user){
        return  userService.registerUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest request) {
        return userService.loginUser(request.getEmail(), request.getPassword());
    }

}
