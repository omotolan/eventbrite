package africa.semicolon.eventbrite.Util;

import africa.semicolon.eventbrite.data.models.User;
import africa.semicolon.eventbrite.dto.requests.RegisterUserRequest;

public class Mapper {
    public static User map(RegisterUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        return user;
    }
}
