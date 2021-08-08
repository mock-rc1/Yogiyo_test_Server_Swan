package com.server.yogiyo.review.controller;

import com.server.yogiyo.configure.response.DataResponse;
import com.server.yogiyo.configure.response.ResponseService;
import com.server.yogiyo.configure.security.authentication.CustomUserDetails;
import com.server.yogiyo.review.service.ReviewService;
import com.server.yogiyo.review.dto.PostReviewReq;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/app")
public class ReviewController {

    private final ReviewService reviewService;
    private final ResponseService responseService;

    @PostMapping("/reviews/complete-Orders/{completeOrdersId}")
    public DataResponse<Long> createReview(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                        @PathVariable(name = "completeOrdersId") Long completeOrdersId,
                                        @RequestBody PostReviewReq postReviewReq) {
        Long reviewId = reviewService.createReview(customUserDetails, completeOrdersId,postReviewReq);
        return responseService.getDataResponse(reviewId);
    }

}
