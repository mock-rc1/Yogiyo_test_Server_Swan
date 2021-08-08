package com.server.yogiyo.review.repository;

import com.server.yogiyo.review.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
