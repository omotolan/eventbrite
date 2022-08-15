package africa.semicolon.eventbrite.services;

import africa.semicolon.eventbrite.data.models.Event;
import africa.semicolon.eventbrite.data.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

}
