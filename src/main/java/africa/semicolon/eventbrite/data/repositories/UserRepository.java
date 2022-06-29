package africa.semicolon.eventbrite.data.repositories;

import africa.semicolon.eventbrite.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}
