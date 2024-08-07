package store.store_api.dto.stores;

import store.store_api.model.Address;

public record ResponseStoreDTO(
        String id,
        String storeName,
        Address address
        ) {
}
