package store.store_api.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
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
    private String storesId;

    private String cpf;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime saleDate;

    private ProductSoldDetail foods;
    private ProductSoldDetail drinks;
    private BigDecimal totalPrice;
    private String paymentMethod;

    public void update(AlterSalesDTO alterSalesDTO) {
        if (alterSalesDTO.paymentMethod() != null) {
            this.paymentMethod = alterSalesDTO.paymentMethod();
        }
    }
}
