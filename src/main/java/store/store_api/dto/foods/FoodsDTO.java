package store.store_api.dto.foods;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public record FoodsDTO(
        @NotBlank
        @Length(min = 5, max = 225)
        String foodName,

        @NotNull
        Integer quantity,

        @NotNull
        BigDecimal price,

        @Length(min = 5, max = 225)
        String description
) {
}
