package store.store_api.dto.sales;

import jakarta.validation.constraints.NotNull;
import store.store_api.model.Sales;
import store.store_api.model.Stores;

import java.time.LocalDateTime;

public record AlterSalesDTO(
        @NotNull
        Long id,

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
    public AlterSalesDTO(Sales sales) {
        this(sales.getId(), sales.getStores(), sales.getSaleDate(), sales.getQuantitySold(),
                sales.getTotalPrice(), sales.getPaymentMethood());
    }
}
