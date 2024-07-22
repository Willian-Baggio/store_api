package store.store_api.dto.drinks;

import jakarta.validation.constraints.NotBlank;
import store.store_api.model.Drinks;

public record DrinksDTO(
        @NotBlank
        String drinkName,

        @NotBlank
        Integer quantity,

        @NotBlank
        Integer price,

        String descripton
) {
        public DrinksDTO(Drinks drinks) {
                this(drinks.getDrinkName(), drinks.getQuantity(),
                        drinks.getPrice(), drinks.getDescription());
        }
}
