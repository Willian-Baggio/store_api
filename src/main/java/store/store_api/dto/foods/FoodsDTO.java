package store.store_api.dto.foods;

import jakarta.validation.constraints.NotBlank;

import java.text.DecimalFormat;

public record FoodsDTO(
        @NotBlank
        String foodName,

        @NotBlank
        Integer quantity,

        @NotBlank
        DecimalFormat price,

        String descripton
) {
}
