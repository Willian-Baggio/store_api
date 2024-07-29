package store.store_api.dto.productsSold;

import jakarta.validation.constraints.NotNull;

public record ProductSoldDTO(
        Long foodsId,
        Long drinksId,

        @NotNull
        Long salesId
) {
}
