package com.codecool.recommendation.repository;

import com.codecool.recommendation.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByVideoIdOrderByRatingDesc(final long videoId);
}
