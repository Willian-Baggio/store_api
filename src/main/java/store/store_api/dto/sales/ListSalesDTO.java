package store.store_api.dto.sales;

import java.math.BigDecimal;

public record ListSalesDTO(
        String id,
        String storesId,
        String cpf,
        ProductSoldDetailDTO foods,
        ProductSoldDetailDTO drinks,
        BigDecimal totalPrice,
        String paymentMethod
) {
}
