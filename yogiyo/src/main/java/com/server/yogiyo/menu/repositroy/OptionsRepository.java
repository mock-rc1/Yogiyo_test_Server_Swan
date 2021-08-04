package com.server.yogiyo.menu.repositroy;

import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.menu.entity.Options;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OptionsRepository extends JpaRepository<Options, Long> {
    Optional<Options> findByOptionsIdAndStatus(Long id, Status status);
}
