package store.store_api.dto.drinks;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import store.store_api.model.Drinks;

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
        public AlterDrinksDTO(Drinks drinks) {
                this(drinks.getId(), drinks.getDrinkName(), drinks.getQuantity(), drinks.getPrice(), drinks.getDescription());
        }
}
