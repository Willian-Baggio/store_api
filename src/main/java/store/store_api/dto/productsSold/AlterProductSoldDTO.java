package store.store_api.dto.productsSold;

import jakarta.validation.constraints.NotNull;
import store.store_api.model.Drinks;
import store.store_api.model.Foods;
import store.store_api.model.ProductsSold;
import store.store_api.model.Sales;

public record AlterProductSoldDTO(
        @NotNull
        Long id,

        Foods foods,
        Drinks drinks,

        @NotNull
        Sales sales
) {
    public AlterProductSoldDTO(ProductsSold productsSold) {
        this(productsSold.getId(), productsSold.getFoods(), productsSold.getDrinks(),
                productsSold.getSales());
    }
}
