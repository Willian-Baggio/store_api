package store.store_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store.store_api.model.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long> {
}
