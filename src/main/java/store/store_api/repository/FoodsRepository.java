package store.store_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store.store_api.model.Foods;

public interface FoodsRepository extends JpaRepository<Foods, Long> {
}
