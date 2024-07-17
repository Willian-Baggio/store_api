package store.store_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store.store_api.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    boolean existsById(Long id);
}
