package com.codecool.video.controller;

import com.codecool.video.entity.Video;
import com.codecool.video.model.Review;
import com.codecool.video.model.VideoDetails;
import com.codecool.video.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/asd")
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private RestTemplate restTemplate;

    //@Value("${recommendation.url}")
    private String baseUrl = "http://localhost:8090/review";

    @GetMapping("/list")
    public List<Video> videoList() {
        return videoRepository.findAll();
    }

    @GetMapping("/details/{id}")
    public VideoDetails retrieveVideo(@PathVariable("id") String id) {
        Video video = videoRepository.findById(Long.valueOf(id)).orElse(null);

        Review[] reviews = restTemplate.getForEntity(baseUrl + "/video/" + id, Review[].class).getBody();

        return new VideoDetails(video, reviews);
    }

    @PostMapping("/updateVideo/{id}")
    public void updateVideo(@RequestBody Video newVideo) {
        Video video = videoRepository.findById(newVideo.getId()).orElse(null);
        if (video != null) {
            video.setName(newVideo.getName());
            video.setUrl(newVideo.getUrl());
            videoRepository.save(video);
        }
    }

    @PostMapping("/addReview")
    public void addReview(@RequestBody Review review) {
        HttpEntity<Review> request = new HttpEntity<>(review);
        restTemplate.postForObject(baseUrl + "/add", request, Review.class);
    }

}
