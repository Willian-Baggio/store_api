package store.store_api.dto.sales;

import java.math.BigDecimal;

public record AlterSalesDTO(
        String id,
        String storesId,
        String usersId,
        Integer quantitySold,
        BigDecimal totalPrice,
        String paymentMethood
) {
}
