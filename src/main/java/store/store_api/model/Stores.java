package store.store_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import store.store_api.dto.stores.AlterStoreDTO;

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

    public Stores(String storeName, Addres addres) {
        this.storeName = storeName;
        this.addres = addres;
    }

    public void update(AlterStoreDTO alterStoreDTO) {
        if (alterStoreDTO.storeName() != null) {
            this.storeName = alterStoreDTO.storeName();
        }
        if (alterStoreDTO.addres() != null) {
            this.addres.update(alterStoreDTO.addres());
        }
    }
}
