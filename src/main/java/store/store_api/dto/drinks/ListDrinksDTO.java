package store.store_api.dto.drinks;

import store.store_api.model.Drinks;

import java.math.BigDecimal;

public record ListDrinksDTO(
        String id,
        String drinkName,
        Integer quantity,
        BigDecimal price,
        String description
) {
        public ListDrinksDTO(Drinks drinks) {
                this(drinks.getId(), drinks.getDrinkName(), drinks.getQuantity(),
                        drinks.getPrice(), drinks.getDescription());
        }
}
