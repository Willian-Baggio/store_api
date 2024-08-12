package store.store_api.dto.sales;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record SalesDTO(
        @NotNull
        String storesId,

        @NotNull
        String cpf,

        @NotNull
        ProductSoldDetailDTO foods,

        @NotNull
        ProductSoldDetailDTO drinks,

        @NotNull
        @Length(min = 5, max = 225,
                message = "Payment method name must be between 4 and 225 characters")
        String paymentMethod
) {
}
