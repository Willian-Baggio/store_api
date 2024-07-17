package store.store_api.dto.foods;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlterFoodsDTO(
        @NotNull
        Long id,

        @NotBlank
        String foodName,

        @NotBlank
        Integer quantity,

        @NotBlank
        Integer price,

        String description
) {
}
