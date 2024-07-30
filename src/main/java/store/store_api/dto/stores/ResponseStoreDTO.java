package store.store_api.dto.stores;

public record ResponseStoreDTO(
        String id,
        String storeName,
        store.store_api.model.Addres addres
        ) {
}
