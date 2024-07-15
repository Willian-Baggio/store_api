package store.store_api.dto.users;

import jakarta.validation.constraints.NotBlank;

public record UserCreateDTO(
        @NotBlank
        String username,

        @NotBlank
        String password,

        @NotBlank
        String email,

        @NotBlank
        String cellphone,

        @NotBlank
        String cpf
) {
}
