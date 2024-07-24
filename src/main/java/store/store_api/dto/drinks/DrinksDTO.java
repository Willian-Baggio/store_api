package store.store_api.dto.drinks;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import store.store_api.model.Drinks;

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
        public DrinksDTO(Drinks drinks) {
                this(drinks.getDrinkName(), drinks.getQuantity(),
                        drinks.getPrice(), drinks.getDescription());
        }
}
