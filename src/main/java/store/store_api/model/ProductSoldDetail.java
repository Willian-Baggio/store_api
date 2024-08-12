package store.store_api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductSoldDetail {

    private String id;
    private Integer quantity;

    public ProductSoldDetail(String id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }
}
