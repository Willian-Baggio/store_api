package store.store_api.dto.drinks;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DrinksDTO(
        @NotBlank
        String drinkName,

        @NotNull
        Integer quantity,

        @NotNull
        BigDecimal price,

        String description
) {
}
