package store.store_api.dto.foods;

import java.math.BigDecimal;

public record ResponseFoodsDTO(
        Long id,
        String foodName,
        Integer quantity,
        BigDecimal price,
        String description
) {
}
