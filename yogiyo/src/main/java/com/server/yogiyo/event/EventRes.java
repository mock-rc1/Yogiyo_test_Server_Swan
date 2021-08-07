package com.server.yogiyo.event;

import com.server.yogiyo.configure.entity.Status;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventRes {
    private Long eventId;

    private Status status;

    private String thumbnail;

    public EventRes(Event event) {
        this.eventId = event.getEventId();
        this.status = event.getStatus();
        this.thumbnail = event.getThumbnail();
    }
}
