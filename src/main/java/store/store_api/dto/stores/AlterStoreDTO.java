package store.store_api.dto.stores;

import jakarta.validation.constraints.NotNull;
import store.store_api.model.Addres;
import store.store_api.model.Stores;

public record AlterStoreDTO(
        @NotNull
        Long id,

        @NotNull
        String storeName,

        @NotNull
        Addres addres
        ) {
        public AlterStoreDTO(Stores stores) {
                this(stores.getId(), stores.getStoreName(), stores.getAddres());
        }
}
