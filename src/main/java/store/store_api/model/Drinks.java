package store.store_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private Integer price;
    private String description;

    public Drinks(String drinkName, Integer quantity, Integer price, String description) {
        this.drinkName = drinkName;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }

    public Drinks(){}

    public Long getId() {
        return id;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
