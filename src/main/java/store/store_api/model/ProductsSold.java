package store.store_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import store.store_api.dto.drinks.DrinksDTO;
import store.store_api.dto.drinks.ListDrinksDTO;
import store.store_api.dto.foods.FoodsDTO;
import store.store_api.dto.foods.ListFoodsDTO;
import store.store_api.dto.productsSold.AlterProductSoldDTO;
import store.store_api.dto.sales.ListSalesDTO;
import store.store_api.dto.sales.SalesDTO;

@Table(name = "products_sold")
@Entity(name = "ProductsSold")
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

    public void update(AlterProductSoldDTO alterProductSoldDTO, Foods foods, Drinks drinks, Sales sales) {
        if (foods != null) {
            this.foods = foods;
        }
        if (drinks != null) {
            this.drinks = drinks;
        }
        if (sales != null) {
            this.sales = sales;
        }
    }
}
