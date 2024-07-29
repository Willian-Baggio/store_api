package store.store_api.dto.productsSold;

import store.store_api.model.ProductsSold;

public record ListProductSoldDTO(
        Long id,
        Long foodsId,
        Long drinksId,
        Long salesId
) {
        public ListProductSoldDTO(ProductsSold productsSold) {
                this(productsSold.getId(), productsSold.getFoods().getId(), productsSold.getDrinks().getId(),
                        productsSold.getSales().getId());
        }
}
