package africa.semicolon.eventbrite.dto.responses;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateEventResponse {
    private String eventName;
    private String eventLocation;
    private String createdBy;
}
