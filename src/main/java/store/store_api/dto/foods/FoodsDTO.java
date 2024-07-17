package store.store_api.dto.foods;

import jakarta.validation.constraints.NotBlank;

public record FoodsDTO(
        @NotBlank
        String foodName,

        @NotBlank
        Integer quantity,

        @NotBlank
        Integer price,

        String descripton
) {
}
