package store.store_api.dto.users;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import store.store_api.dto.addres.AddresDataDTO;

public record AlterUserDTO(
        @NotNull
        Long id,

        @NotBlank
        String username,

        @NotBlank
        String email,

        @NotBlank
        String cellphone,

        @NotBlank
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")
        String cpf,

        @NotNull
        @Valid
        AddresDataDTO addresDataDTO
) {
}
