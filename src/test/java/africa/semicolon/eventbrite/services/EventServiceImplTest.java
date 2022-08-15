package africa.semicolon.eventbrite.services;

import africa.semicolon.eventbrite.data.models.Event;
import africa.semicolon.eventbrite.data.repositories.EventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EventServiceImplTest {
    @Autowired
    private EventService eventServiceImpl;
    @Autowired
    private EventRepository eventRepository;

    @Test
    public void addNewPartyTest() {
        Event event = new Event();
        Event savedEvent = eventServiceImpl.saveEvent(event);

        assertEquals(1, eventRepository.count());
    }

}