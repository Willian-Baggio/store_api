package store.store_api.dto.sales;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ListSalesDTO(
        String id,
        String storesId,
        String cpf,
        LocalDateTime saleDate,
        ProductSoldDetailDTO foods,
        ProductSoldDetailDTO drinks,
        BigDecimal totalPrice,
        String paymentMethod
) {
}
