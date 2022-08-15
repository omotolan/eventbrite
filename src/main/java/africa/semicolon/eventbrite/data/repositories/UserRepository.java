package africa.semicolon.eventbrite.data.repositories;

import africa.semicolon.eventbrite.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);

    Optional<User> findUserByEmail(String email);
}
