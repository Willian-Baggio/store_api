package store.store_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import store.store_api.dto.stores.AlterStoreDTO;

@Document(collection = "stores")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Stores {

    @Id
    private String id;
    private String storeName;
    private Address address;

    public Stores(String storeName, Address address) {
        this.storeName = storeName;
        this.address = address;
    }

    public void update(AlterStoreDTO alterStoreDTO) {
        if (alterStoreDTO.storeName() != null) {
            this.storeName = alterStoreDTO.storeName();
        }
        if (alterStoreDTO.address() != null) {
            this.address.update(alterStoreDTO.address());
        }
    }
}
