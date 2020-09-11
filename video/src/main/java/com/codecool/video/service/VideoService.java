package com.codecool.video.service;

import com.codecool.video.entity.Video;
import com.codecool.video.model.VideoDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class VideoService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${recommendation.url}")
    private String baseUrl;

    public VideoDetails getRecommendationsByVideoId(long videoId) {
        return restTemplate.getForEntity(baseUrl + "/", VideoDetails.class).getBody();
    }
}
