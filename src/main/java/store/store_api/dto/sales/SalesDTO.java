package store.store_api.dto.sales;

import jakarta.validation.constraints.NotNull;
import store.store_api.model.Stores;

import java.time.LocalDateTime;

public record SalesDTO(
        @NotNull
        Stores stores,

        @NotNull
        LocalDateTime saleDate,

        @NotNull
        Integer quantitySold,

        @NotNull
        Integer totalPrice,

        @NotNull
        String paymentMethood
) {
}
