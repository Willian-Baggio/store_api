package store.store_api.dto.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import store.store_api.model.Address;

public record AlterAddressDTO(
        @NotBlank
        String id,

        @Length(min = 5, max = 225,
                message = "Street name must be between 5 and 225 characters")
        String street,

        @Length(min = 5, max = 225,
                message = "Neighborhood name must be between 5 and 225 characters")
        String neighborhood,

        @Pattern(regexp = "\\d{5}-\\d{3}",
                message = "Zip code must follow the pattern 12345-678")
        String zipCode,

        String number,

        @Length(min = 5, max = 225,
                message = "Complement name must be between 5 and 225 characters")
        String complement,

        @Length(min = 3, max = 225,
                message = "City name must be between 3 and 225 characters")
        String city,

        @Length(min = 2, max = 2,
                message = "UF name must be between 2 and 2 characters")
        String uf
) {
}
