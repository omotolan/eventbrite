package africa.semicolon.eventbrite.services;

import africa.semicolon.eventbrite.data.models.Event;

public interface EventService {
    Event saveEvent(Event event);
}
