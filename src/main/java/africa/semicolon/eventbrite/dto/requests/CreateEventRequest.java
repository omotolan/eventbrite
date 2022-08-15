package africa.semicolon.eventbrite.dto.requests;

import lombok.Data;

@Data
public class CreateEventRequest {
    private  String email;
    private String eventName;
    private String eventLocation;
}
