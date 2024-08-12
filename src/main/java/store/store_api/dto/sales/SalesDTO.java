package store.store_api.dto.sales;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import store.store_api.dto.users.UserCreateDTO;
import store.store_api.model.Sales;
import store.store_api.model.Stores;
import store.store_api.model.Users;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SalesDTO(
        @NotNull
        String storeId,

        @NotNull
        UserCreateDTO cpf,

        @NotNull
        Integer quantitySold,

        @NotNull
        BigDecimal totalPrice,

        @NotNull
        @Length(min = 5, max = 225,
                message = "Payment method name must be between 5 and 225 characters")
        String paymentMethod
) {
}
