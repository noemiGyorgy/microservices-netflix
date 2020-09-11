package com.codecool.video.model;

import com.codecool.video.entity.Video;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDetails {

    Video video;
    List<Review> reviews;
}
