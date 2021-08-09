package com.server.yogiyo.review.repository;

import com.server.yogiyo.restaurant.entity.Restaurant;
import com.server.yogiyo.review.dto.GetReviewRes;
import com.server.yogiyo.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("select r from Review r left join fetch r.completeOrders c where (c.restaurant = :restaurant and r.status = 'Valid')")
    List<GetReviewRes> findAllByRestaurant(Restaurant restaurant);

}
