package store.store_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import store.store_api.dto.productsSold.AlterProductSoldDTO;

@Table(name = "product_sold")
@Entity(name = "ProductSold")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProductsSold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Foods foods;

    @ManyToOne(fetch = FetchType.LAZY)
    private Drinks drinks;

    @ManyToOne(fetch = FetchType.LAZY)
    private Sales sales;

    public ProductsSold(Foods foods, Drinks drinks, Sales sales) {
        this.foods = foods;
        this.drinks = drinks;
        this.sales = sales;
    }

    public void update(AlterProductSoldDTO alterProductSoldDTO) {
        if (alterProductSoldDTO.foods() != null) {
            this.foods = alterProductSoldDTO.foods();
        }
        if (alterProductSoldDTO.drinks() != null) {
            this.drinks = alterProductSoldDTO.drinks();
        }
        if (alterProductSoldDTO.sales() != null) {
            this.sales = alterProductSoldDTO.sales();
        }
    }
}
