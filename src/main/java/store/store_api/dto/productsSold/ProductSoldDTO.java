package store.store_api.dto.productsSold;

import jakarta.validation.constraints.NotNull;

public record ProductSoldDTO(
        String foodsId,
        String drinksId,

        @NotNull
        String salesId
) {
}
