package com.crm.backend.service;

import com.crm.backend.config.JwtUtil;
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

    @Autowired
    private JwtUtil jwtUtil;

    public User registerUser(RegisterRequest request){
        if(userRepository.findByEmail(request.getEmail()) != null){

            throw new RuntimeException("Email already exists");
        }
        User user=new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("USER");
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
        String token = jwtUtil.generateToken(user.getEmail());
        return token;
    }
}
