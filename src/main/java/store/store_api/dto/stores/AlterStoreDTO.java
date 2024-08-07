package store.store_api.dto.stores;

import jakarta.validation.constraints.NotNull;

public record AlterStoreDTO(
        @NotNull
        String id,
        String storeName,
        store.store_api.model.Address address
        ) {
}
