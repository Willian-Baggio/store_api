package store.store_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import store.store_api.model.Users;

public interface LoginRepository extends JpaRepository<Users, Long> {
    UserDetails findByLogin(String login);
}
