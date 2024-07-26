package store.store_api.dto.users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import store.store_api.dto.addres.AlterAddresDTO;

public record AlterUserDTO(
        @NotNull
        Long id,
        String username,
        String email,
        String cellphone,
        @NotBlank
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")
        String cpf,
        AlterAddresDTO addres
) {
}
