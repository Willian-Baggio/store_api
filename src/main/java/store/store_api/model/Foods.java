package store.store_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import store.store_api.dto.foods.AlterFoodsDTO;

import java.math.BigDecimal;

@Document(collection = "foods")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Foods {

    @Id
    private String id;

    private String foodName;
    private Integer quantity;
    private BigDecimal price;
    private String description;

    public Foods(String foodName, Integer quantity, BigDecimal price, String description) {
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }

    public void update(AlterFoodsDTO alterFoodsDTO) {
        if (alterFoodsDTO.foodName() != null) {
            this.foodName = alterFoodsDTO.foodName();
        }
        if (alterFoodsDTO.quantity() != null) {
            this.quantity = alterFoodsDTO.quantity();
        }
        if (alterFoodsDTO.price() != null) {
            this.price = alterFoodsDTO.price();
        }
        if (alterFoodsDTO.description() != null) {
            this.description = alterFoodsDTO.description();
        }
    }
}
