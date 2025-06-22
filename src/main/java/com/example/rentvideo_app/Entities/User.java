package com.example.rentvideo_app.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "User")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role role;

}
// @Entity
// @Table(name = "users")
// @Data
// public class User {

    
// }
