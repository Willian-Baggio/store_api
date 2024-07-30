package store.store_api.dto.drinks;

import java.math.BigDecimal;

public record ResponseDrinksDTO(
        String id,
        String drinkName,
        Integer quantity,
        BigDecimal price,
        String description
) {
}
