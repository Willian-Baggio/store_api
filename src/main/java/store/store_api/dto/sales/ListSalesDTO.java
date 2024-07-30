package store.store_api.dto.sales;

import store.store_api.model.Sales;

import java.math.BigDecimal;

public record ListSalesDTO(
        String id,
        String storeId,
        String userId,
        Integer quantitySold,
        BigDecimal totalPrice,
        String paymentMethood
) {
        public ListSalesDTO(Sales sales) {
                this(sales.getId(), sales.getStores(), sales.getUsers(),
                        sales.getQuantitySold(), sales.getTotalPrice(),
                        sales.getPaymentMethood());
        }
}
