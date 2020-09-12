package com.codecool.video.repository;

import com.codecool.video.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VideoRepository extends JpaRepository<Video, Long> {

    @Override
    List<Video> findAll();
}
