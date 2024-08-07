package store.store_api.dto.users;

import jakarta.validation.constraints.NotNull;
import store.store_api.dto.address.AlterAddressDTO;

public record AlterUserDTO(
        @NotNull
        String id,
        String username,
        String email,
        String cellphone,
        String cpf,
        AlterAddressDTO address
) {
}
