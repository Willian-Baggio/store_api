package store.store_api.dto.address;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import store.store_api.model.Address;

public record AlterAddressDTO(
        @NotBlank
        String id,

        @Length(min = 5, max = 225)
        String street,

        @Length(min = 5, max = 225)
        String neighborhood,

        String zipCode,

        @Length(min = 5, max = 225)
        String number,

        @Length(min = 5, max = 225)
        String complement,

        @Length(min = 5, max = 225)
        String city,

        @Length(min = 2, max = 2)
        String uf
) {
}
