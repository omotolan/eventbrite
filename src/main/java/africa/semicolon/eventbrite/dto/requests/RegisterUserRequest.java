package africa.semicolon.eventbrite.dto.requests;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterUserRequest {
    private String email;
    private  String firstName;
    private String lastName;
    private String password;
}
