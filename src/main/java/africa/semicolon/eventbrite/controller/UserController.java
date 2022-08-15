package africa.semicolon.eventbrite.controller;

import africa.semicolon.eventbrite.Exceptions.DuplicatedEmailException;
import africa.semicolon.eventbrite.Exceptions.UserDoesNotExistException;
import africa.semicolon.eventbrite.dto.requests.CreateEventRequest;
import africa.semicolon.eventbrite.dto.requests.LoginUserRequest;
import africa.semicolon.eventbrite.dto.requests.RegisterUserRequest;
import africa.semicolon.eventbrite.dto.responses.ApiResponse;
import africa.semicolon.eventbrite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody RegisterUserRequest registerUserRequest) {
        try {
            var serviceResponse = userService.registerUser(registerUserRequest);
            ApiResponse response = new ApiResponse(true, serviceResponse);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (DuplicatedEmailException exception) {
            ApiResponse response = new ApiResponse(false, exception.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/user/login")
    public ResponseEntity<?> login(@RequestBody LoginUserRequest loginUserRequest) {
        try {
            return new ResponseEntity<>(userService.loginUser(loginUserRequest), HttpStatus.OK);
        }
        catch (IllegalArgumentException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/event")
    public ResponseEntity<?> createEvent(@RequestBody CreateEventRequest createPartyRequest){
        try {
            var serviceResponse = userService.addEvent(createPartyRequest);
            ApiResponse response = new ApiResponse(true, serviceResponse);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (UserDoesNotExistException ex){
            ApiResponse response = new ApiResponse(false, ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
