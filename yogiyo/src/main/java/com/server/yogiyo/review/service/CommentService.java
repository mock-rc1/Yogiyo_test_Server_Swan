package com.server.yogiyo.review.service;

import com.server.yogiyo.account.entity.Account;
import com.server.yogiyo.configure.response.exception.CustomException;
import com.server.yogiyo.configure.response.exception.CustomExceptionStatus;
import com.server.yogiyo.configure.security.authentication.CustomUserDetails;
import com.server.yogiyo.review.dto.PostCommentReq;
import com.server.yogiyo.review.entity.Comment;
import com.server.yogiyo.review.entity.Review;
import com.server.yogiyo.review.repository.CommentRepository;
import com.server.yogiyo.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public Long createParentComment(CustomUserDetails customUserDetails, Long reviewId, PostCommentReq req) {

        Account account = customUserDetails.getAccount();
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new CustomException(CustomExceptionStatus.NOT_EXIST_REVIEW));

        Comment save = commentRepository.save(new Comment(account, review, null, req));
        if(!review.getCompleteOrders().getRestaurant().getAccount().getAccountId().equals(account.getAccountId()))
            throw new CustomException(CustomExceptionStatus.ACCOUNT_NOT_VALID);
        return save.getCommentId();
    }

    @Transactional
    public Long createNestedComment(CustomUserDetails customUserDetails, Long commentId, PostCommentReq req) {
        Account account = customUserDetails.getAccount();
        Comment parentComment = commentRepository.findCommentIncludeReviewById(commentId)
                .orElseThrow(() -> new CustomException(CustomExceptionStatus.NOT_EXIST_COMMENT));
        Review review = parentComment.getReview();

        Comment save = commentRepository.save(new Comment(account, review, parentComment, req));
        return save.getCommentId();
    }

}
