package com.server.yogiyo.review.dto;

import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.review.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GetReviewRes {

    private Long reviewId;

    private Status status;

    private Integer taste;

    private Integer portions;

    private Integer delivery;

    private String image1;
    private String image2;
    private String image3;
    private String image4;

    private String contents;

    private Long likeCount;

    private Long reportCount;

    public GetReviewRes(Review review) {

        this.reviewId = review.getReviewId();

        this.status = review.getStatus();

        this.taste = review.getTaste();

        this.portions = review.getPortions();

        this.delivery = review.getDelivery();

        this.image1 = review.getImage1();
        this.image2 = review.getImage2();
        this. image3 = review.getImage3();
        this.image4 = review.getImage4();

        this.contents = review.getContents();

        this.likeCount = review.getLikeCount();

        this.reportCount = review.getReportCount();

    }

}
