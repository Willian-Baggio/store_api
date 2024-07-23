package store.store_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import store.store_api.dto.foods.AlterFoodsDTO;
import store.store_api.dto.foods.FoodsDTO;

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
    private DecimalFormat price;
    private String description;

    public Foods(FoodsDTO foodsDTO) {
        this.foodName = foodsDTO.foodName();
        this.quantity = foodsDTO.quantity();
        this.price = foodsDTO.price();
        this.description = foodsDTO.descripton();
    }

    public Foods(Foods foods) {
    }

    public Foods(AlterFoodsDTO alterFoodsDTO) {
    }
}
