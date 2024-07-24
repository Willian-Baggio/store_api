package store.store_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import store.store_api.dto.sales.AlterSalesDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "sales")
@Entity(name = "Sales")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Stores stores;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users users;

    private LocalDateTime saleDate;
    private Integer quantitySold;
    private BigDecimal totalPrice;
    private String paymentMethood;

    public Sales(Sales sales) {
        this.id = sales.getId();
        this.stores = sales.getStores();
        this.users = sales.getUsers();
        this.saleDate = LocalDateTime.now();
        this.quantitySold = sales.getQuantitySold();
        this.totalPrice = sales.getTotalPrice();
        this.paymentMethood = sales.getPaymentMethood();
    }

    public Sales(Stores stores, Users users, Integer quantitySold, BigDecimal totalPrice, String paymentMethood) {
        this.stores = stores;
        this.users = users;
        this.quantitySold = quantitySold;
        this.totalPrice = totalPrice;
        this.paymentMethood = paymentMethood;
    }

    public Sales(AlterSalesDTO alterSalesDTO) {
    }
}
