package store.store_api.dto.sales;

import java.math.BigDecimal;

public record AlterSalesDTO(
        Long id,
        Long storesId,
        Long usersId,
        Integer quantitySold,
        BigDecimal totalPrice,
        String paymentMethood
) {
}
