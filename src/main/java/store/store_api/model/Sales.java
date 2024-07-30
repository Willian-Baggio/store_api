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
    private String users;

    private LocalDateTime saleDate;
    private Integer quantitySold;
    private BigDecimal totalPrice;
    private String paymentMethood;

    public Sales(String stores, String users, Integer quantitySold, BigDecimal totalPrice, String paymentMethood) {
        this.stores = stores;
        this.users = users;
        this.quantitySold = quantitySold;
        this.totalPrice = totalPrice;
        this.paymentMethood = paymentMethood;
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
        if (alterSalesDTO.paymentMethood() != null) {
            this.paymentMethood = alterSalesDTO.paymentMethood();
        }
    }
}
