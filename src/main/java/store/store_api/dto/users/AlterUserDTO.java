package store.store_api.dto.users;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import store.store_api.dto.address.AlterAddressDTO;

public record AlterUserDTO(
        @NotBlank
        String id,

        @Length(min = 5, max = 225)
        String username,

        @Length(min = 5, max = 225)
        String email,

        @Length(min = 5, max = 225)
        String cellphone,

        String cpf,
        AlterAddressDTO address
) {
}
