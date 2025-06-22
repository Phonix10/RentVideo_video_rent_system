package com.example.rentvideo_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.rentvideo_app.entity.User;
import com.example.rentvideo_app.entity.Role.Role;
import com.example.rentvideo_app.repository.UserRepository;

@Service
public class UserService {

    @Autowired 
    private UserRepository userRepository;

    @Autowired 
    private BCryptPasswordEncoder passwordEncoder;


    public User registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("User with email " + user.getEmail() + " already exists.");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRole() == null) {
            user.setRole(Role.CUSTOMER);
        }

        return userRepository.save(user); 
    }


    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }   
}
