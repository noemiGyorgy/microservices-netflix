package com.codecool.video.controller;

import com.codecool.video.entity.Video;
import com.codecool.video.model.Review;
import com.codecool.video.model.ReviewList;
import com.codecool.video.model.VideoDetails;
import com.codecool.video.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${recommendation.url}")
    private String baseUrl;

    @GetMapping("/list")
    public List<Video> videoList() {
        return videoRepository.findAll();
    }

    @GetMapping("/details/{id}")
    public VideoDetails retrieveVideo(@PathVariable("id") Long id) {
        Video video = videoRepository.findById(id).orElse(null);
        ReviewList response = restTemplate.getForObject(baseUrl + "/video/" + id.toString(), ReviewList.class);
        List<Review> reviews = response.getReviews();
        return new VideoDetails(video, reviews);
    }

    @PostMapping("/add_review")
    public void addReview(@RequestBody Review review) {
        HttpEntity<Review> request = new HttpEntity<>(review);
        restTemplate.postForObject(baseUrl + "/add", request, Review.class);
    }

}
