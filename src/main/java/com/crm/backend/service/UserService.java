package com.crm.backend.service;

import com.crm.backend.config.JwtUtil;
import com.crm.backend.dto.LoginResponse;
import com.crm.backend.dto.RegisterRequest;
import com.crm.backend.entity.User;
import com.crm.backend.exception.EmailAlreadyExistsException;
import com.crm.backend.exception.InvalidCredentialsException;
import com.crm.backend.exception.InvalidPasswordException;
import com.crm.backend.exception.UserNotFoundException;
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
            throw new EmailAlreadyExistsException("Email already exists");
        }
        User user=new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("USER");
        return userRepository.save(user);
    }

    public LoginResponse loginUser(String email,String password){
        User user=userRepository.findByEmail(email);
        if(user==null){
            throw new UserNotFoundException("User not found");
        }
        if(!passwordEncoder.matches(password,user.getPassword())){
            throw new InvalidCredentialsException("Invalid password");
        }
        String token = jwtUtil.generateToken(user.getEmail());
        return new LoginResponse(token,user.getName(), user.getRole());
    }

    public String changePassword(String email,String oldPassword,String newPassword,String confirmPassword){
        User user=userRepository.findByEmail(email);

        if(user==null){
            throw new UserNotFoundException("User not found");
        }
        if(!passwordEncoder.matches(oldPassword,user.getPassword())){
            throw new InvalidPasswordException(("Old password is incorrect"));
        }
        if(!newPassword.equals(confirmPassword)){
            throw new InvalidPasswordException("New password and confirm password do not match");
        }
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
        return "Password changed successfully";
    }
}
