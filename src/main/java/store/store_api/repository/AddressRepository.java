package store.store_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import store.store_api.model.Address;

public interface AddressRepository extends MongoRepository<Address, String> {
    boolean existsByZipCode(String zipCode);
}
