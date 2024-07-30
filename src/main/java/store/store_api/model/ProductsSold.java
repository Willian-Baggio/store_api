package store.store_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import store.store_api.dto.productsSold.AlterProductSoldDTO;

@Document(collection = "products_sold")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductsSold {

    @Id
    private String id;
    private String foods;
    private String drinks;
    private String sales;

    public ProductsSold(String foods, String drinks, String sales) {
        this.foods = foods;
        this.drinks = drinks;
        this.sales = sales;
    }

    public void update(AlterProductSoldDTO alterProductSoldDTO, String foods, String drinks, String sales) {
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
