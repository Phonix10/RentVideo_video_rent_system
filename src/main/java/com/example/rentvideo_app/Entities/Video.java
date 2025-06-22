package com.example.rentvideo_app.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Video")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String director;
    private String genre;

    private boolean available = true;
}