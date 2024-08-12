package store.store_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import store.store_api.dto.sales.AlterSalesDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "sales")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Sales {

    @Id
    private String id;
    private String stores;

    private String cpf;
    private LocalDateTime saleDate;
    private Integer quantitySold;
    private BigDecimal totalPrice;
    private String paymentMethod;

    public Sales(String stores, String cpf, Integer quantitySold, BigDecimal totalPrice, String paymentMethod) {
        this.stores = stores;
        this.cpf = cpf;
        this.quantitySold = quantitySold;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.saleDate = LocalDateTime.now();
    }

    public void update(AlterSalesDTO alterSalesDTO) {
//        if (alterSalesDTO.storesId() != null) {
//            this.stores = alterSalesDTO.storesId();
//        }
//        if (alterSalesDTO.usersId() != null) {
//            this.users = alterSalesDTO.usersId();
//        }
        if (alterSalesDTO.quantitySold() != null) {
            this.quantitySold = alterSalesDTO.quantitySold();
        }
        if (alterSalesDTO.totalPrice() != null) {
            this.totalPrice = alterSalesDTO.totalPrice();
        }
        if (alterSalesDTO.paymentMethod() != null) {
            this.paymentMethod = alterSalesDTO.paymentMethod();
        }
    }
}
