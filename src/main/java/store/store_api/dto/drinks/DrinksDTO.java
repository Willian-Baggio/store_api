package store.store_api.dto.drinks;

import jakarta.validation.constraints.NotBlank;

public record DrinksDTO(
        @NotBlank
        String drinkName,

        @NotBlank
        Integer quantity,

        @NotBlank
        Integer price,

        String descripton
) {
}
