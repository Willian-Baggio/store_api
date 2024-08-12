package store.store_api.dto.foods;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public record AlterFoodsDTO(
        @NotBlank
        String id,

        @Length(min = 5, max = 225,
                message = "Food name must be between 5 and 225 characters")
        String foodName,

        Integer quantity,
        BigDecimal price,

        @Length(min = 5, max = 225,
                message = "Food name must be between 5 and 225 characters")
        String description
) {
}
