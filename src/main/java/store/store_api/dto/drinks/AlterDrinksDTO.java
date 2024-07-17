package store.store_api.dto.drinks;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlterDrinksDTO(
        @NotNull
        Long id,

        @NotBlank
        String drinkName,

        @NotBlank
        Integer quantity,

        @NotBlank
        Integer price,

        String description
) {
}
