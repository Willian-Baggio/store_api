package store.store_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import store.store_api.model.Foods;

public interface FoodsRepository extends MongoRepository<Foods, String> {
}
