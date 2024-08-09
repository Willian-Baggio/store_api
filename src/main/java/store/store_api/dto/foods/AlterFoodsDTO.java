package store.store_api.dto.foods;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public record AlterFoodsDTO(
        @NotBlank
        String id,

        @Length(min = 5, max = 225)
        String foodName,

        Integer quantity,
        BigDecimal price,

        @Length(min = 5, max = 225)
        String description
) {
}
