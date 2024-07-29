package store.store_api.dto.stores;

import store.store_api.dto.addres.ListAddresDTO;
import store.store_api.model.Addres;
import store.store_api.model.Stores;

public record ListStoreDTO(
        Long id,
        String storeName,
        ListAddresDTO addres
        ) {
        public ListStoreDTO(Stores stores) {
                this(stores.getId(), stores.getStoreName(), new ListAddresDTO(stores.getAddres()));
        }
}
