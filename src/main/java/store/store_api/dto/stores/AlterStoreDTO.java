package store.store_api.dto.stores;

import jakarta.validation.constraints.NotNull;
import store.store_api.dto.addres.AlterAddresDTO;

public record AlterStoreDTO(
        @NotNull
        Long id,
        String storeName,
        AlterAddresDTO addres
        ) {
}
