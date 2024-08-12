package store.store_api.dto.stores;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import store.store_api.dto.address.AddressDataDTO;

public record StoreCreateDTO(
        @Length(min = 5, max = 225,
                message = "Store name must be between 5 and 225 characters")
        String storeName,

        @NotNull
        AddressDataDTO address
        ) {
}
