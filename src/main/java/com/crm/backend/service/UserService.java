package com.crm.backend.service;

import com.crm.backend.dto.RegisterRequest;
import com.crm.backend.entity.User;
import com.crm.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
    private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

    public User registerUser(RegisterRequest request){
        User user=new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        return userRepository.save(user);
    }

    public String loginUser(String email,String password){
        User user=userRepository.findByEmail(email);
        if(user==null){
            return "User not found";
        }
        if(!passwordEncoder.matches(password,user.getPassword())){
            return "Invalid password";
        }
        return "Login successful";
    }
}
