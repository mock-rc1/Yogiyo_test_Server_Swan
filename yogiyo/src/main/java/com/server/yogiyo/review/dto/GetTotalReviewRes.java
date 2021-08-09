package com.server.yogiyo.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GetTotalReviewRes {

    private Double avgTaste;

    private Double avgPortions;

    private Double avgDelivery;

    List<GetReviewRes> reviewList = new ArrayList<>();


    public GetTotalReviewRes(List<GetReviewRes> list) {
        this.reviewList = list;
        this.avgTaste = 0D;
        this.avgPortions = 0D;
        this.avgDelivery = 0D;
        if (list.size() > 1) {
            for (GetReviewRes getReviewRes : list) {
                this.avgTaste += getReviewRes.getTaste();
                this.avgPortions += getReviewRes.getPortions();
                this.avgDelivery += getReviewRes.getDelivery();
            }
            avgTaste = Math.ceil(avgTaste * 100 / list.size())/100.0;
            avgPortions = Math.ceil(avgPortions * 100 / list.size())/100.0;
            avgDelivery = Math.ceil(avgDelivery * 100 / list.size())/100.0;
        }
    }
}
