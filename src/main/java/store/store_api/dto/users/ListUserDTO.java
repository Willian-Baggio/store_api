package store.store_api.dto.users;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import store.store_api.model.Addres;
import store.store_api.model.Users;

public record ListUserDTO(
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
        Addres addres
) {
    public ListUserDTO(Users users) {
        this(users.getId(), users.getUsername(), users.getEmail(), users.getCellphone(),
                users.getCpf(), users.getAddres());
    }
}
