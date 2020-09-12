package com.codecool.video.model;

import com.codecool.video.entity.Video;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDetails {

    Video video;
    Review[] reviews;
}
