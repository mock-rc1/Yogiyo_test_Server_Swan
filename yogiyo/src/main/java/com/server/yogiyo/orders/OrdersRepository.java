package com.server.yogiyo.orders;

import com.server.yogiyo.account.entity.Account;
import com.server.yogiyo.configure.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByAccountAndStatus(Account account, Status status);
}
