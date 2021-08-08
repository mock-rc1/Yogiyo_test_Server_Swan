package com.server.yogiyo.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostReviewReq {

    private Integer taste;

    private Integer portions;

    private Integer delivery;

    private String image1;
    private String image2;
    private String image3;
    private String image4;

    private String contents;

}
