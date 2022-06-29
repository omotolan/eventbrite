package africa.semicolon.eventbrite.services;

import africa.semicolon.eventbrite.dto.requests.LoginUserRequest;
import africa.semicolon.eventbrite.dto.requests.RegisterUserRequest;
import africa.semicolon.eventbrite.dto.responses.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest request);

    String loginUser(LoginUserRequest loginUserRequest);
}
