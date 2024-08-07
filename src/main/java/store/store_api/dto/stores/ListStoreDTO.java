package store.store_api.dto.stores;

import store.store_api.dto.address.ListAddressDTO;

public record ListStoreDTO(
        String id,
        String storeName,
        ListAddressDTO address
        ) {
}
