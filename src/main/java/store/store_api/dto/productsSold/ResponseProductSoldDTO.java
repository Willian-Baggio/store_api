package store.store_api.dto.productsSold;

public record ResponseProductSoldDTO(
        String id,
        String foodsId,
        String drinksId,
        String salesId
) {
}
