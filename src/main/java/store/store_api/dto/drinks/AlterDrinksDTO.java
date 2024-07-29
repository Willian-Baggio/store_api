package store.store_api.dto.drinks;

import jakarta.validation.constraints.NotNull;
import store.store_api.model.Drinks;

import java.math.BigDecimal;

public record AlterDrinksDTO(
        @NotNull
        Long id,
        String drinkName,
        Integer quantity,
        BigDecimal price,
        String description
) {
}
