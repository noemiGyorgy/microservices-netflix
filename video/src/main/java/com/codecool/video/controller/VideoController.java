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

    @Value("${recommendation.url}")
    private String baseUrl;

    @GetMapping("/list")
    public List<Video> videoList() {
        return videoRepository.findAll();
    }

    @GetMapping("/details")
    public VideoDetails retrieveVideo() {
        Video video = videoRepository.findById(1L).orElse(null);

       // Review[] reviews = restTemplate.getForEntity(baseUrl + "/video/" + id.toString(), Review[].class).getBody();
        Review[] reviews = restTemplate.getForEntity("http://localhost:8090/review/video/1", Review[].class).getBody();
        System.out.println("RESPONSE ");
        for (Review i: reviews) {

            System.out.println("aaaaaaaaaaaa " + i);
        }
        return new VideoDetails(video, reviews);
    }

    @PostMapping("/add_review")
    public void addReview(@RequestBody Review review) {
        HttpEntity<Review> request = new HttpEntity<>(review);
        restTemplate.postForObject(baseUrl + "/add", request, Review.class);
    }

}
