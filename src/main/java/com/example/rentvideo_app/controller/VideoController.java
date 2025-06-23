package com.example.rentvideo_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.rentvideo_app.entity.*;
import com.example.rentvideo_app.service.*;

@RestController
@RequestMapping("/api/videos")
public class VideoController {

    @Autowired 
    private VideoService videoService;

    
    @GetMapping
    @PreAuthorize("isAuthenticated()") 
    public ResponseEntity<List<Video>> getAllAvailableVideos() {
        List<Video> videos = videoService.getAllAvailableVideos();
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()") 
    public ResponseEntity<Video> getVideoById(@PathVariable Long id) {
        Optional<Video> video = videoService.getVideoById(id);
        return video.map(v -> new ResponseEntity<>(v, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

   
    @PostMapping("/admin") 
    @PreAuthorize("hasRole('ADMIN')") 
    public ResponseEntity<Video> createVideo(@RequestBody Video video) {
        Video createdVideo = videoService.createVideo(video);
        return new ResponseEntity<>(createdVideo, HttpStatus.CREATED);
    }

    @PutMapping("/admin/{id}") 
    @PreAuthorize("hasRole('ADMIN')") 
    public ResponseEntity<Video> updateVideo(@PathVariable Long id, @RequestBody Video videoDetails) {
        try {
            Video updatedVideo = videoService.updateVideo(id, videoDetails);
            return new ResponseEntity<>(updatedVideo, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/admin/{id}")
    @PreAuthorize("hasRole('ADMIN')") 
    public ResponseEntity<Void> deleteVideo(@PathVariable Long id) {
        try {
            videoService.deleteVideo(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}