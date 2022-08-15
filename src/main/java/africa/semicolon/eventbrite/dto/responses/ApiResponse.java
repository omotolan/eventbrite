package africa.semicolon.eventbrite.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class ApiResponse {
    private boolean isSuccessful;
    private Object data;
}
