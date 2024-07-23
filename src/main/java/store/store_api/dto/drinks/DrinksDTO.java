package store.store_api.dto.drinks;

import jakarta.validation.constraints.NotBlank;
import store.store_api.model.Drinks;

import java.text.DecimalFormat;

public record DrinksDTO(
        @NotBlank
        String drinkName,

        @NotBlank
        Integer quantity,

        @NotBlank
        DecimalFormat price,

        String descripton
) {
        public DrinksDTO(Drinks drinks) {
                this(drinks.getDrinkName(), drinks.getQuantity(),
                        drinks.getPrice(), drinks.getDescription());
        }
}
