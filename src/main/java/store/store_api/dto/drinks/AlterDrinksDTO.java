package store.store_api.dto.drinks;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import store.store_api.model.Drinks;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public record AlterDrinksDTO(
        @NotNull
        Long id,

        @NotBlank
        String drinkName,

        @NotNull
        Integer quantity,

        @NotNull
        BigDecimal price,

        String description
) {
        public AlterDrinksDTO(Drinks drinks) {
                this(drinks.getId(), drinks.getDrinkName(), drinks.getQuantity(), drinks.getPrice(), drinks.getDescription());
        }
}
