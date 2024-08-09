package store.store_api.dto.stores;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import store.store_api.dto.address.AlterAddressDTO;

public record AlterStoreDTO(
        @NotBlank
        String id,

        @Length(min = 5, max = 225)
        String storeName,
        AlterAddressDTO address
        ) {
}
