package com.server.yogiyo.event;

import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.configure.response.DataResponse;
import com.server.yogiyo.configure.response.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.server.yogiyo.configure.entity.Status.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/app")
public class EventController {

    private final EventRepository eventRepository;
    private final ResponseService responseService;

    @GetMapping("/events")
    public DataResponse<List<EventRes>> getEventList() {
        List<EventRes> eventList = eventRepository.findAllByStatusAndIsAdOrderByUpdatedAtDesc(Valid,false);
        return responseService.getDataResponse(eventList);
    }

    @GetMapping("/ads")
    public DataResponse<List<EventRes>> getAdList() {
        List<EventRes> adList = eventRepository.findAllByStatusAndIsAdOrderByUpdatedAtDesc(Valid,true);
        return responseService.getDataResponse(adList);
    }

}

