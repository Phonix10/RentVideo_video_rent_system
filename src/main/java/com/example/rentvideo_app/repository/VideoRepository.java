package com.example.rentvideo_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.rentvideo_app.entity.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long>{
    List<Video> findByAvailabilityStatusTrue();
} 