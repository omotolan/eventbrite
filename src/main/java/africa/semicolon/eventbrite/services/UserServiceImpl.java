package africa.semicolon.eventbrite.services;

import africa.semicolon.eventbrite.Exceptions.DuplicatedEmailException;
import africa.semicolon.eventbrite.Exceptions.InvalidDetailsException;
import africa.semicolon.eventbrite.Exceptions.UserDoesNotExistException;
import africa.semicolon.eventbrite.Util.Mapper;
import africa.semicolon.eventbrite.data.models.Event;
import africa.semicolon.eventbrite.data.models.User;
import africa.semicolon.eventbrite.data.repositories.UserRepository;
import africa.semicolon.eventbrite.dto.requests.CreateEventRequest;
import africa.semicolon.eventbrite.dto.requests.LoginUserRequest;
import africa.semicolon.eventbrite.dto.requests.RegisterUserRequest;
import africa.semicolon.eventbrite.dto.responses.CreateEventResponse;
import africa.semicolon.eventbrite.dto.responses.LoginResponse;
import africa.semicolon.eventbrite.dto.responses.RegisterUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final EventService eventService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, EventService eventService) {
        this.userRepository = userRepository;
        this.eventService = eventService;
    }

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {

        User user = Mapper.map(request);

        if (user.getEmail().equals(request.getEmail())) {
            throw new DuplicatedEmailException(request.getEmail() + "Email already exists");
        }
        User savedUser = userRepository.save(user);
        RegisterUserResponse response = new RegisterUserResponse();
        response.setEmail(savedUser.getEmail());
        response.setDateCreated(DateTimeFormatter.ofPattern("EEEE, dd/MM/yy,hh:mm,a").format(savedUser.getDateTime()));
        return response;
    }


    @Override
    public LoginResponse loginUser(LoginUserRequest loginUserRequest) {
        User user = userRepository.findByEmail(loginUserRequest.getEmail());
        if (user == null) {
            throw new UserDoesNotExistException("User does not exist");
        }
        if (!Objects.equals(user.getPassword(), loginUserRequest.getPassword())) {
            throw new InvalidDetailsException("Invalid login details");
        }
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage("Logged in");

        return loginResponse;
    }

    @Override
    public CreateEventResponse addEvent(CreateEventRequest createEventRequest) {
        //check if user exists
        // throw exception if user does not exist

        // create party
        // save party
        // add party to list of user's party
        // save the user
        // return response

        Optional<User> optionalUser = userRepository.findUserByEmail(createEventRequest.getEmail());
        if (optionalUser.isEmpty()) {
            throw new UserDoesNotExistException(createEventRequest.getEmail() + " email does not exist");
        }
        User foundUser = optionalUser.get();
        Event event = new Event();
        event.setLocation(createEventRequest.getEventLocation());
        event.setName(createEventRequest.getEventName());
        Event savedEvent = eventService.saveEvent(event);
        foundUser.getEvents().add(savedEvent);
        userRepository.save(foundUser);

        CreateEventResponse response = new CreateEventResponse();
        response.setEventLocation(savedEvent.getLocation());
        response.setCreatedBy(foundUser.getFirstName());
        response.setEventName(savedEvent.getName());
        return response;
    }
}
