package com.example.rentvideo_app.entity;

import com.example.rentvideo_app.entity.Role.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column(unique = true, nullable = false) 
    private String email;

    private String password; 

    @Column(name = "first_name") 
    private String firstName;

    @Column(name = "last_name") 
    private String lastName;

    @Enumerated(EnumType.STRING) 
    private Role role; 


    
}
