package store.store_api.dto.sales;

import jakarta.validation.constraints.NotNull;
import store.store_api.model.Sales;
import store.store_api.model.Stores;
import store.store_api.model.Users;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SalesDTO(
        @NotNull
        Long storeId,

        @NotNull
        Long userId,

        @NotNull
        Integer quantitySold,

        @NotNull
        BigDecimal totalPrice,

        @NotNull
        String paymentMethood
) {
}
