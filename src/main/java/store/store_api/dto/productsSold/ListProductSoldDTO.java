package store.store_api.dto.productsSold;

import store.store_api.model.ProductsSold;

public record ListProductSoldDTO(
        String id,
        String foodsId,
        String drinksId,
        String salesId
) {
        public ListProductSoldDTO(ProductsSold productsSold) {
                this(productsSold.getId(), productsSold.getFoods(), productsSold.getDrinks(),
                        productsSold.getSales());
        }
}
