package com.codecool.video.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {

    private long id;

    private int rating;

    private String comment;

    private Long videoId;

}
