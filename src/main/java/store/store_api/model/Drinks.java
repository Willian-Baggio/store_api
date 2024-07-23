package store.store_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import store.store_api.dto.drinks.AlterDrinksDTO;
import store.store_api.dto.drinks.DrinksDTO;

import java.text.DecimalFormat;

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
    private DecimalFormat price;
    private String description;

    public Drinks(DrinksDTO drinksDTO) {
        this.drinkName = drinksDTO.drinkName();
        this.quantity = drinksDTO.quantity();
        this.price = drinksDTO.price();
        this.description = drinksDTO.descripton();
    }

    public Drinks(Drinks drinks){}

    public Drinks(AlterDrinksDTO alterDrinksDTO) {
    }
}
