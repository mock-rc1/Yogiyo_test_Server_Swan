package com.server.yogiyo.event;

import com.server.yogiyo.configure.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByStatus(Status status);
}
