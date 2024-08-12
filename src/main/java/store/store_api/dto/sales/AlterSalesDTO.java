package store.store_api.dto.sales;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record AlterSalesDTO(
        @NotBlank
        String id,

        @NotNull
        @Length(min = 5, max = 225,
                message = "Payment method name must be between 5 and 225 characters")
        String paymentMethod
) {
}
