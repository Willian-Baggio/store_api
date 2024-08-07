package store.store_api.dto.stores;

import jakarta.validation.constraints.NotNull;
import store.store_api.dto.address.AddressDataDTO;

public record StoreCreateDTO(
        @NotNull
        String storeName,

        @NotNull
        AddressDataDTO address
        ) {
}
