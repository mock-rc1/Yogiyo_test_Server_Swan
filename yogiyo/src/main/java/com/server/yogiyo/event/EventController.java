package com.server.yogiyo.event;

import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.configure.response.DataResponse;
import com.server.yogiyo.configure.response.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/app")
public class EventController {

    private final EventService eventService;

    @GetMapping("/events")
    public DataResponse<List<EventRes>> getEventList() {
        return eventService.getEventList();
    }

}

