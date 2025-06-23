package com.example.rentvideo_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.rentvideo_app.entity.User;
import com.example.rentvideo_app.service.UserService;

@RestController
@RequestMapping("/api/auth") // base path
public class AuthController {

    @Autowired 
    private UserService userService;

 
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        try {
            User registeredUser = userService.registerUser(user);
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    
    @GetMapping("/login")
    public ResponseEntity<String> loginSuccess() {
        return new ResponseEntity<>("Login successful!", HttpStatus.OK);
    }
    
}
