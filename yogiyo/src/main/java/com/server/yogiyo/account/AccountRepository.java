package com.server.yogiyo.account;

import com.server.yogiyo.account.entity.Account;
import com.server.yogiyo.configure.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByEmailAndStatus(String email, Status status);
    Optional<Account> findByNicknameAndStatus(String nickname, Status status);
    Optional<Account> findByKakaoIdAndStatus(Long kakaoId, Status status);
}
