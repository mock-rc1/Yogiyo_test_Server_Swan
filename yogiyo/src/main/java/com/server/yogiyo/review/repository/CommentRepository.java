package com.server.yogiyo.review.repository;

import com.server.yogiyo.review.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select c from Comment c left join fetch c.review r where (c.commentId = :id and c.status = 'Valid')")
    Optional<Comment> findCommentIncludeReviewById(Long id);
}
