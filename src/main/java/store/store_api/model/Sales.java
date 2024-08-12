package store.store_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import store.store_api.dto.sales.AlterSalesDTO;

import java.math.BigDecimal;

@Document(collection = "sales")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Sales {

    @Id
    private String id;
    private String storesId;

    private String cpf;
    private ProductSoldDetail foods;
    private ProductSoldDetail drinks;
    private BigDecimal totalPrice;
    private String paymentMethod;

    public Sales(String storesId, String cpf, ProductSoldDetail foods, ProductSoldDetail drinks, BigDecimal totalPrice, String paymentMethod) {
        this.storesId = storesId;
        this.cpf = cpf;
        this.foods = foods;
        this.drinks = drinks;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
    }

    public void update(AlterSalesDTO alterSalesDTO) {
        if (alterSalesDTO.paymentMethod() != null) {
            this.paymentMethod = alterSalesDTO.paymentMethod();
        }
    }
}
