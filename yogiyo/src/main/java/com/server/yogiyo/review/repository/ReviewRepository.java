package com.server.yogiyo.review.repository;

import com.server.yogiyo.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
