package africa.semicolon.eventbrite.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Document("Users")
public class User {
    @Id
    private  String id;
    private String email;
    private  String firstName;
    private String lastName;
    private String password;
    private LocalDateTime dateTime = LocalDateTime.now();
    @DBRef
    private List<Event> events = new ArrayList<>();

}
