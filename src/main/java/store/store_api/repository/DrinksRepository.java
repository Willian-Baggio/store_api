package store.store_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import store.store_api.dto.drinks.DrinksDTO;
import store.store_api.model.Drinks;

public interface DrinksRepository extends MongoRepository<Drinks, String> {
}
