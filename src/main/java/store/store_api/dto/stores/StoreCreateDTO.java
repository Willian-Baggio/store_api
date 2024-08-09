package store.store_api.dto.stores;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import store.store_api.dto.address.AddressDataDTO;

public record StoreCreateDTO(
        @NotNull
        @Length(min = 5, max = 225)
        String storeName,

        @NotNull
        AddressDataDTO address
        ) {
}
