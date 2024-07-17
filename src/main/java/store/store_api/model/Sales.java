package store.store_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private Integer totalPrice;
    private String paymentMethood;
}
