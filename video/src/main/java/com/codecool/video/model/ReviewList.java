package com.codecool.video.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ReviewList {

    private List<Review> reviews;

    public ReviewList() {
        reviews = new ArrayList<>();
    }
}
