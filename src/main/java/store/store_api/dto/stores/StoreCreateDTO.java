package store.store_api.dto.stores;

import jakarta.validation.constraints.NotNull;

public record StoreCreateDTO(
        @NotNull
        String storeName
) {
}
