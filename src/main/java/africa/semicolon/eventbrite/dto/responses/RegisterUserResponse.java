package africa.semicolon.eventbrite.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterUserResponse {
    private String email;
    private String dateCreated;
}
