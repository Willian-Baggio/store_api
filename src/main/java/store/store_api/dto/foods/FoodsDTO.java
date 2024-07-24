package store.store_api.dto.foods;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public record FoodsDTO(
        @NotBlank
        String foodName,

        @NotNull
        Integer quantity,

        @NotNull
        BigDecimal price,

        String description
) {
}
