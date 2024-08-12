package store.store_api.dto.sales;

import java.math.BigDecimal;

public record ResponseSaleDTO(
        String id,
        String storesId,
        String cpf,
        ProductSoldDetailDTO foods,
        ProductSoldDetailDTO drinks,
        BigDecimal totalPrice,
        String paymentMethod
) {
}
