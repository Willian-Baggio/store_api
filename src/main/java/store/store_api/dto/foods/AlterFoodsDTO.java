package store.store_api.dto.foods;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import store.store_api.model.Foods;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public record AlterFoodsDTO(
        @NotNull
        Long id,

        @NotBlank
        String foodName,

        @NotNull
        Integer quantity,

        @NotNull
        BigDecimal price,

        String description
) {
        public AlterFoodsDTO(Foods foods) {
                this(foods.getId(), foods.getFoodName(), foods.getQuantity(), foods.getPrice(),
                        foods.getDescription());
        }
}
