package store.store_api.dto.productsSold;

public record ResponseProductSoldDTO(
        String foodsId,
        String drinksId,
        String salesId
) {
}
