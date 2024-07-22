package store.store_api.dto.foods;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import store.store_api.model.Foods;

public record AlterFoodsDTO(
        @NotNull
        Long id,

        @NotBlank
        String foodName,

        @NotBlank
        Integer quantity,

        @NotBlank
        Integer price,

        String description
) {
        public AlterFoodsDTO(Foods foods) {
                this(foods.getId(), foods.getFoodName(), foods.getQuantity(), foods.getPrice(),
                        foods.getDescription());
        }
}
