package store.store_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import store.store_api.model.Sales;

public interface SalesRepository extends MongoRepository<Sales, String> {
}
