package com.server.yogiyo.review.controller;

import com.server.yogiyo.configure.response.DataResponse;
import com.server.yogiyo.configure.response.ResponseService;
import com.server.yogiyo.configure.security.authentication.CustomUserDetails;
import com.server.yogiyo.review.dto.GetTotalReviewRes;
import com.server.yogiyo.review.entity.Review;
import com.server.yogiyo.review.service.ReviewService;
import com.server.yogiyo.review.dto.PostReviewReq;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/app")
public class ReviewController {

    private final ReviewService reviewService;
    private final ResponseService responseService;

    @PostMapping("/reviews/complete-orders/accounts/auth/{completeOrdersId}")
    public DataResponse<Long> createReview(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                        @PathVariable(name = "completeOrdersId") Long completeOrdersId,
                                        @RequestBody PostReviewReq postReviewReq) {
        Long reviewId = reviewService.createReview(customUserDetails, completeOrdersId,postReviewReq);
        return responseService.getDataResponse(reviewId);
    }

    @GetMapping("/reviews/restaurants/{restaurantId}")
    public DataResponse<GetTotalReviewRes> findReviewListByRestaurantId(@PathVariable(name = "restaurantId") Long restaurantId) {
        GetTotalReviewRes reviewList = reviewService.findReviewListByRestaurantId(restaurantId);
        return responseService.getDataResponse(reviewList);
    }

}
