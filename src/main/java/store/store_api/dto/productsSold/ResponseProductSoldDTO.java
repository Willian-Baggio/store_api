package store.store_api.dto.productsSold;

import store.store_api.model.Drinks;
import store.store_api.model.Foods;
import store.store_api.model.Sales;

public record ResponseProductSoldDTO(
        Foods foods,
        Drinks drinks,
        Sales sales
) {
}
