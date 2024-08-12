package store.store_api.dto.sales;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public record AlterSalesDTO(
        @NotBlank
        String id,
        String storesId,
        String usersId,
        Integer quantitySold,
        BigDecimal totalPrice,

        @Length(min = 5, max = 225,
                message = "Payment method name must be between 5 and 225 characters")
        String paymentMethod
) {
}
