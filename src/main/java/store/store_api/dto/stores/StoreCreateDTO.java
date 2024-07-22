package store.store_api.dto.stores;

import jakarta.validation.constraints.NotNull;
import store.store_api.model.Addres;

public record StoreCreateDTO(
        @NotNull
        String storeName,

        @NotNull
        Addres addres
        ) {
}
