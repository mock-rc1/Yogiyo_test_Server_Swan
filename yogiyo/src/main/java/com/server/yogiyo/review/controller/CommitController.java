package com.server.yogiyo.review.controller;

import com.server.yogiyo.configure.response.DataResponse;
import com.server.yogiyo.configure.response.ResponseService;
import com.server.yogiyo.configure.security.authentication.CustomUserDetails;
import com.server.yogiyo.review.dto.PostCommentReq;
import com.server.yogiyo.review.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/app")
public class CommitController {

    private final CommentService commentService;
    private final ResponseService responseService;

    @PostMapping("/reviews/{reviewId}/comments")
    public DataResponse<Long> createParentComment(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                                  @PathVariable(name = "reviewId") Long reviewId, @RequestBody PostCommentReq req) {
        Long commentId = commentService.createParentComment(customUserDetails, reviewId, req);
        return responseService.getDataResponse(commentId);
    }
}
