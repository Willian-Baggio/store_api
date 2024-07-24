package store.store_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import store.store_api.dto.addres.AddresDataDTO;
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

//    @OneToMany
//    private List<Sales> sales;

    public Stores(Stores stores) {
        this.id = stores.getId();
        this.storeName = stores.getStoreName();
        this.addres = stores.getAddres();
    }

    public Stores(String storeName, Addres addres) {
        this.storeName = storeName;
        this.addres = addres;
    }

    public Stores(AlterStoreDTO alterStoreDTO) {
    }

}
