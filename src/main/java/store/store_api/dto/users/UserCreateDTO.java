package store.store_api.dto.users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import store.store_api.dto.address.AddressDataDTO;

public record UserCreateDTO(
        @NotBlank
        String login,

        @NotBlank
        String username,

        @NotBlank
        String password,

        @NotBlank
        String email,

        @NotBlank
        String cellphone,

        @NotBlank
        String cpf,

        @NotNull
        AddressDataDTO address
) {
}
