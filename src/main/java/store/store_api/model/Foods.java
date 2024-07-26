package store.store_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import store.store_api.dto.foods.AlterFoodsDTO;

import java.math.BigDecimal;

@Table(name = "foods")
@Entity(name = "Foods")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Foods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
