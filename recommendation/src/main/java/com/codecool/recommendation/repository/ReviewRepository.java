package com.codecool.recommendation.repository;

import com.codecool.recommendation.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByVideoId(long videoId);
}
