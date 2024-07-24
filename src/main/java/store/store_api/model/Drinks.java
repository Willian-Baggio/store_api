package store.store_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import store.store_api.dto.drinks.AlterDrinksDTO;
import store.store_api.dto.drinks.DrinksDTO;

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

    public Drinks(DrinksDTO drinksDTO) {
        this.drinkName = drinksDTO.drinkName();
        this.quantity = drinksDTO.quantity();
        this.price = drinksDTO.price();
        this.description = drinksDTO.description();
    }

    public Drinks(Drinks drinks){
        this.id = drinks.getId();
        this.drinkName = drinks.getDrinkName();
        this.quantity = drinks.getQuantity();
        this.price = drinks.getPrice();
        this.description = drinks.getDescription();
    }

    public Drinks(String drinkName, Integer quantity, BigDecimal price, String description) {
        this.drinkName = drinkName;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }

    public Drinks(AlterDrinksDTO alterDrinksDTO) {
    }
}
