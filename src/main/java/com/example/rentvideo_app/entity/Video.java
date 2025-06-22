package com.example.rentvideo_app.entity;

import jakarta.persistence.*;
import lombok.*;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Entity 
@Table(name = "video") 
public class Video {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    private String title;
    private String director;
    private String genre;
    private boolean availabilityStatus;
}
