package store.store_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store.store_api.model.Addres;

public interface AddresRepository extends JpaRepository<Addres, Long> {
    boolean existsByZipCode(String zipCode);
}
