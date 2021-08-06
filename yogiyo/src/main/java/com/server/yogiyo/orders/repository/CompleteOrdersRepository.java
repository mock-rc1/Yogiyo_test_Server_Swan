package com.server.yogiyo.orders.repository;

import com.server.yogiyo.account.entity.Account;
import com.server.yogiyo.orders.entity.CompleteOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompleteOrdersRepository extends JpaRepository<CompleteOrders, Long> {


    @Query("select c from CompleteOrders  c left join fetch c.ordersList o left join fetch c.restaurant r")
    List<CompleteOrders> findAllByAccount(Account account);
}
