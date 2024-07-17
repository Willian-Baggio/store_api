package store.store_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
}
