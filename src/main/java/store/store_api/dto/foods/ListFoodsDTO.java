package store.store_api.dto.foods;

import java.math.BigDecimal;

public record ListFoodsDTO(
        String id,
        String foodName,
        Integer quantity,
        BigDecimal price,
        String description
) {
}
