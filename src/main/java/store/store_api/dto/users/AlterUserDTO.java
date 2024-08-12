package store.store_api.dto.users;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import store.store_api.dto.address.AlterAddressDTO;

public record AlterUserDTO(
        @NotBlank
        String id,

        @Length(min = 5, max = 225,
                message = "User name must be between 5 and 225 characters")
        String username,

        @Length(min = 5, max = 225,
                message = "Email must be between 5 and 225 characters")
        String email,

        @Length(min = 5, max = 225,
                message = "Cellphone must be between 5 and 225 characters")
        String cellphone,

        String cpf,

        AlterAddressDTO address
) {
}
