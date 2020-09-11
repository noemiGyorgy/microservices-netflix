package com.codecool.recommendation.controller;

import com.codecool.recommendation.entity.Review;
import com.codecool.recommendation.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/video/{videoId}")
    public List<Review> retrieveVideo(@PathVariable Long videoId) {
        return reviewRepository.findAllByVideoId(videoId);
    }

    @PostMapping("/add")
    public void addReview(@RequestBody Review review) {
        reviewRepository.save(review);
    }
}
