package com.server.yogiyo.event;

import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.configure.response.DataResponse;
import com.server.yogiyo.configure.response.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class EventService {

    private final EventRepository eventRepository;
    private final ResponseService responseService;


    public DataResponse<List<EventRes>> getEventList() {
        List<Event> eventList = eventRepository.findAllByStatusOrderByUpdatedAtDesc(Status.Valid);
        return responseService.getDataResponse(eventList.stream().map(EventRes::new).collect(Collectors.toList()));
    }

}
