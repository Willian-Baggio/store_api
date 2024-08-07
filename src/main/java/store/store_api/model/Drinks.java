package store.store_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import store.store_api.dto.drinks.AlterDrinksDTO;

import java.math.BigDecimal;

@Document(collection = "drinks")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Drinks {

    @Id
    private String id;

    private String drinkName;
    private Integer quantity;
    private BigDecimal price;
    private String description;

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
