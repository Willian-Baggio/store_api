package store.store_api.dto.productsSold;

import jakarta.validation.constraints.NotNull;
import store.store_api.model.Drinks;
import store.store_api.model.Foods;
import store.store_api.model.Sales;

public record ProductSoldDTO(
        Foods foods,
        Drinks drinks,

        @NotNull
        Sales sales
) {
}
