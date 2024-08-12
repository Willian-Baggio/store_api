package store.store_api.dto.sales;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ResponseSaleDTO(
        String id,
        String storesId,
        String usersId,
        LocalDateTime saleDate,
        Integer quantitySold,
        BigDecimal totalPrice,
        String paymentMethod

) {
}
