package store.store_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import store.store_api.model.ProductsSold;

public interface ProductsSoldRepository extends MongoRepository<ProductsSold, String> {
}
