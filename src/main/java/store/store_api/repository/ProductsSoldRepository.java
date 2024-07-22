package store.store_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store.store_api.model.ProductsSold;

public interface ProductsSoldRepository extends JpaRepository<ProductsSold, Long> {
}
