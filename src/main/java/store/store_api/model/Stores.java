package store.store_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import store.store_api.dto.stores.AlterStoreDTO;
import store.store_api.dto.stores.StoreCreateDTO;

import java.util.List;

@Table(name = "stores")
@Entity(name = "Stores")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Stores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String storeName;

    @OneToOne(fetch = FetchType.LAZY)
    private Addres addres;

    @OneToMany
    private List<Sales> sales;

    public Stores(StoreCreateDTO storeCreateDTO) {
    }

    public Stores(Stores stores) {
    }

    public Stores(AlterStoreDTO alterStoreDTO) {
    }
}
