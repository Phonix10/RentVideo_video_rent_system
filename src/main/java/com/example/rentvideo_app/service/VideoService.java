package com.example.rentvideo_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentvideo_app.entity.Video;
import com.example.rentvideo_app.repository.VideoRepository;

@Service
public class VideoService {

    @Autowired 
    private VideoRepository videoRepository;

   
    public List<Video> getAllAvailableVideos() {
        return videoRepository.findByAvailabilityStatusTrue();
    }

    
    public Optional<Video> getVideoById(Long id) {
        return videoRepository.findById(id);   // return An Optional containing the Video if found, empty otherwise.
    }

   
    public Video createVideo(Video video) {
        // Ensure availability status is true for newly created videos as per requirements
        video.setAvailabilityStatus(true);
        return videoRepository.save(video);
    }


    public Video updateVideo(Long id, Video videoDetails) {

        Video existingVideo = videoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Video not found with id: " + id));

        existingVideo.setTitle(videoDetails.getTitle());
        existingVideo.setDirector(videoDetails.getDirector());
        existingVideo.setGenre(videoDetails.getGenre());
        existingVideo.setAvailabilityStatus(videoDetails.isAvailabilityStatus()); // Update availability status

        return videoRepository.save(existingVideo); // Save the updated video
    }

  
    public void deleteVideo(Long id) {
        if (!videoRepository.existsById(id)) {
            throw new RuntimeException("Video not found with id: " + id);
        }
        videoRepository.deleteById(id); 
    }
}