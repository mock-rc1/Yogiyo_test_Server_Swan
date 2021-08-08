package com.server.yogiyo.review.service;

import com.server.yogiyo.account.entity.Account;
import com.server.yogiyo.configure.response.exception.CustomException;
import com.server.yogiyo.configure.response.exception.CustomExceptionStatus;
import com.server.yogiyo.configure.security.authentication.CustomUserDetails;
import com.server.yogiyo.orders.entity.CompleteOrders;
import com.server.yogiyo.orders.repository.CompleteOrdersRepository;
import com.server.yogiyo.review.entity.Review;
import com.server.yogiyo.review.dto.PostReviewReq;
import com.server.yogiyo.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ReviewService {

    private final CompleteOrdersRepository completeOrdersRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public Long createReview(CustomUserDetails customUserDetails, Long completeOrdersId,PostReviewReq req) {
        CompleteOrders completeOrders = completeOrdersRepository.findById(completeOrdersId)
                .orElseThrow(() -> new CustomException(CustomExceptionStatus.NOT_EXIST_COMPLETE_ORDERS));
        Account account = customUserDetails.getAccount();
        if (!completeOrders.getAccount().getAccountId().equals(account.getAccountId()))
            throw new CustomException(CustomExceptionStatus.ACCOUNT_NOT_VALID);

        Review save = reviewRepository.save(new Review(req, completeOrders));
        return save.getReviewId();
    }
}
