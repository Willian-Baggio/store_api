package store.store_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import store.store_api.model.Stores;

public interface StoresRepository extends MongoRepository<Stores, String> {
}
