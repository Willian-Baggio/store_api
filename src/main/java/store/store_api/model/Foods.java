package store.store_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import store.store_api.dto.foods.AlterFoodsDTO;
import store.store_api.dto.foods.FoodsDTO;

import java.math.BigDecimal;
import java.text.DecimalFormat;

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

    public Foods(FoodsDTO foodsDTO) {
        this.foodName = foodsDTO.foodName();
        this.quantity = foodsDTO.quantity();
        this.price = foodsDTO.price();
        this.description = foodsDTO.description();
    }

    public Foods(Foods foods) {
        this.id = foods.getId();
        this.foodName = foods.getFoodName();
        this.quantity = foods.getQuantity();
        this.price = foods.getPrice();
        this.description = foods.getDescription();
    }

    public Foods(String foodName, Integer quantity, BigDecimal price, String description) {
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }

    public Foods(AlterFoodsDTO alterFoodsDTO) {
    }

}
