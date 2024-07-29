package store.store_api.dto.sales;

import store.store_api.model.Sales;

import java.math.BigDecimal;

public record ListSalesDTO(
        Long id,
        Long storeId,
        Long userId,
        Integer quantitySold,
        BigDecimal totalPrice,
        String paymentMethood
) {
        public ListSalesDTO(Sales sales) {
                this(sales.getId(), sales.getStores().getId(), sales.getUsers().getId(),
                        sales.getQuantitySold(), sales.getTotalPrice(),
                        sales.getPaymentMethood());
        }
}
