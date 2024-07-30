package store.store_api.dto.foods;

import store.store_api.model.Foods;

import java.math.BigDecimal;

public record AlterFoodsDTO(
        String id,
        String foodName,
        Integer quantity,
        BigDecimal price,
        String description
) {
}
