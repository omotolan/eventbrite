package africa.semicolon.eventbrite.services;

import africa.semicolon.eventbrite.data.models.User;
import africa.semicolon.eventbrite.data.repositories.UserRepository;
import africa.semicolon.eventbrite.dto.requests.LoginUserRequest;
import africa.semicolon.eventbrite.dto.requests.RegisterUserRequest;
import africa.semicolon.eventbrite.dto.responses.RegisterUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());

        User savedUser = userRepository.save(user);
        RegisterUserResponse response = new RegisterUserResponse();
        response.setEmail(savedUser.getEmail());
        response.setDateCreated(DateTimeFormatter.ofPattern("EEEE, dd/MM/yy,hh:mm,a").format(savedUser.getDateTime()));
        return response;
    }

    @Override
    public String loginUser(LoginUserRequest loginUserRequest) {
        User user = userRepository.findByEmail(loginUserRequest.getEmail());
        if (user == null){
            throw new IllegalArgumentException("Email does not exists");
        }
        if (!Objects.equals(user.getPassword(), loginUserRequest.getPassword())){
            throw new IllegalArgumentException("wrong password");
        }
        return "logged in";
    }
}
