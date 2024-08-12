package store.store_api.dto.stores;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import store.store_api.dto.address.AlterAddressDTO;

public record AlterStoreDTO(
        @NotBlank
        String id,

        @Length(min = 5, max = 225,
                message = "Store name must be between 5 and 225 characters")
        String storeName,

        AlterAddressDTO address
        ) {
}
