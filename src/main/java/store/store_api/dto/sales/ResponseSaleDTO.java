package store.store_api.dto.sales;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ResponseSaleDTO(
        Long id,
        Long storesId,
        Long usersId,
        LocalDateTime saleDate,
        Integer quantitySold,
        BigDecimal totalPrice,
        String paymentMethood

) {
}
