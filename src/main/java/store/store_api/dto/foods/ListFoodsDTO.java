package store.store_api.dto.foods;

import store.store_api.model.Foods;

import java.math.BigDecimal;

public record ListFoodsDTO(
        String id,
        String foodName,
        Integer quantity,
        BigDecimal price,
        String description
) {
        public ListFoodsDTO(Foods foods) {
                this(foods.getId(), foods.getFoodName(), foods.getQuantity(), foods.getPrice(),
                        foods.getDescription());
        }
}
