package store.store_api.dto.productsSold;

public record ResponseProductSoldDTO(
        Long foodsId,
        Long drinksId,
        Long salesId
) {
}
