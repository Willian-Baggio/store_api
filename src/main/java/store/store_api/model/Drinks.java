package store.store_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import store.store_api.dto.drinks.AlterDrinksDTO;

import java.math.BigDecimal;

@Table(name = "drinks")
@Entity(name = "Drinks")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Drinks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String drinkName;
    private Integer quantity;
    private BigDecimal price;
    private String description;

    public Drinks(String drinkName, Integer quantity, BigDecimal price, String description) {
        this.drinkName = drinkName;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }

    public void update(AlterDrinksDTO alterDrinksDTO) {
        if (alterDrinksDTO.drinkName() != null) {
            this.drinkName = alterDrinksDTO.drinkName();
        }
        if (alterDrinksDTO.quantity() != null) {
            this.quantity = alterDrinksDTO.quantity();
        }
        if (alterDrinksDTO.price() != null) {
            this.price = alterDrinksDTO.price();
        }
        if (alterDrinksDTO.description() != null) {
            this.description = alterDrinksDTO.description();
        }
    }
}
