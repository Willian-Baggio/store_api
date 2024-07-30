package store.store_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import store.store_api.model.Users;

public interface LoginRepository extends MongoRepository<Users, String> {
    UserDetails findByLogin(String login);
}
