package store.store_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store.store_api.model.Stores;

public interface StoresRepository extends JpaRepository<Stores, Long> {
}
