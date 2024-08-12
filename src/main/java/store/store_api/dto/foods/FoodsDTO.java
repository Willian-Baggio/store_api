package store.store_api.dto.foods;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public record FoodsDTO(
        @NotBlank
        @Length(min = 5, max = 225,
                message = "Food name must be between 5 and 225 characters")
        String foodName,

        @NotNull
        Integer quantity,

        @NotNull
        BigDecimal price,

        @Length(min = 5, max = 225,
                message = "Food description must be between 5 and 225 characters")
        String description
) {
}
