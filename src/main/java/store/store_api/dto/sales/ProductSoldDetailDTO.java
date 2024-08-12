package store.store_api.dto.sales;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductSoldDetailDTO(
        @NotBlank
        String id,

        @NotNull
        Integer quantity
) {
}
