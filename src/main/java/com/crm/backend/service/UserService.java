package com.crm.backend.service;

import com.crm.backend.entity.User;
import com.crm.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
    private UserRepository userRepository;

    public User registerUser(User user){
       return userRepository.save(user);
    }

    public String loginUser(String email,String password){
        User user=userRepository.findByEmail(email);
        if(user==null){
            return "User not found";
        }
        if(!user.getPassword().equals(password)){
            return "Invalid password";
        }
        return "Login successful";
    }
}
