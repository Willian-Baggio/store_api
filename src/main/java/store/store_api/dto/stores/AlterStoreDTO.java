package store.store_api.dto.stores;

import jakarta.validation.constraints.NotNull;
import store.store_api.dto.address.AlterAddressDTO;

public record AlterStoreDTO(
        @NotNull
        String id,
        String storeName,
        AlterAddressDTO address
        ) {
}
