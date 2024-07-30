package store.store_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import store.store_api.model.Addres;

public interface AddresRepository extends MongoRepository<Addres, String> {
    boolean existsByZipCode(String zipCode);
}
