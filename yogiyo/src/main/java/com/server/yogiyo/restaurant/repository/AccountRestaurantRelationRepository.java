package com.server.yogiyo.restaurant.repository;


import com.server.yogiyo.account.entity.Account;
import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.restaurant.entity.AccountRestaurantRelation;
import com.server.yogiyo.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountRestaurantRelationRepository extends JpaRepository<AccountRestaurantRelation, Long> {
    @Query("select r from AccountRestaurantRelation  r where (r.account = :account and r.restaurant = :restaurant and r.status = :status and r.isLike = :isLike)")
    List<AccountRestaurantRelation> findByAccountAndRestaurantAndStatusAndIsLike(Account account, Restaurant restaurant, Status status, Boolean isLike);
}
