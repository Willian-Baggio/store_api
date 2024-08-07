package store.store_api.dto.address;

import jakarta.validation.constraints.NotBlank;
import store.store_api.model.Address;

public record AlterAddressDTO(
        @NotBlank
        String id,
        String street,
        String neighborhood,
        String zipCode,
        String number,
        String complement,
        String city,
        String uf
) {
}
