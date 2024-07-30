package store.store_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import store.store_api.model.Users;

public interface UsersRepository extends MongoRepository<Users, String> {
//    boolean existsById(Long id);
}
