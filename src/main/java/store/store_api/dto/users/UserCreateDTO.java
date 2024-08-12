package store.store_api.dto.users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import store.store_api.dto.address.AddressDataDTO;

public record UserCreateDTO(
        @NotBlank
        @Length(min = 5, max = 225,
                message = "Login must be between 5 and 225 characters")
        String login,

        @NotBlank
        @Length(min = 5, max = 225,
                message = "User name must be between 5 and 225 characters")
        String username,

        @NotBlank
        String password,

        @NotBlank
        @Length(min = 5, max = 225,
                message = "email must be between 5 and 225 characters")
        String email,

        @NotBlank
        @Length(min = 5, max = 225,
                message = "Cellphone must be between 5 and 225 characters")
        String cellphone,

        @NotBlank
        String cpf,

        @NotNull
        AddressDataDTO address
) {
}
