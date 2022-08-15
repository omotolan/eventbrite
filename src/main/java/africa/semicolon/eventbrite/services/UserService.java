package africa.semicolon.eventbrite.services;

import africa.semicolon.eventbrite.dto.requests.CreateEventRequest;
import africa.semicolon.eventbrite.dto.requests.LoginUserRequest;
import africa.semicolon.eventbrite.dto.requests.RegisterUserRequest;
import africa.semicolon.eventbrite.dto.responses.CreateEventResponse;
import africa.semicolon.eventbrite.dto.responses.LoginResponse;
import africa.semicolon.eventbrite.dto.responses.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest request);

    LoginResponse loginUser(LoginUserRequest loginUserRequest);

    CreateEventResponse addEvent(CreateEventRequest createEventRequest);
}
