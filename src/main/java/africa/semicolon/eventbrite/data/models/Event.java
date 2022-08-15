package africa.semicolon.eventbrite.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@NoArgsConstructor
public class Event {
    @Id
    private String id;
    private String name;
    private String location;
}
