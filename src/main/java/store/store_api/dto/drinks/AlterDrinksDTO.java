package store.store_api.dto.drinks;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public record AlterDrinksDTO(
        @NotBlank
        String id,

        @Length(min = 5, max = 225,
                message = "Drink name must be between 5 and 225 characters")
        String drinkName,

        Integer quantity,
        BigDecimal price,

        @Length(min = 5, max = 225,
                message = "Drink description must be between 5 and 225 characters")
        String description
) {
}
