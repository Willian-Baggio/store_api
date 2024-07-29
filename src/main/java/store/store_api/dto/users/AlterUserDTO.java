package store.store_api.dto.users;

import jakarta.validation.constraints.NotNull;
import store.store_api.dto.addres.AlterAddresDTO;

public record AlterUserDTO(
        @NotNull
        Long id,
        String username,
        String email,
        String cellphone,
        String cpf,
        AlterAddresDTO addres
) {
}
