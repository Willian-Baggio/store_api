package store.store_api.dto.sales;

import store.store_api.dto.users.ListUserDTO;

import java.math.BigDecimal;

public record ListSalesDTO(
        String id,
        String storeId,
        ListUserDTO listUserDTO,
        Integer quantitySold,
        BigDecimal totalPrice,
        String paymentMethod
) {
}
