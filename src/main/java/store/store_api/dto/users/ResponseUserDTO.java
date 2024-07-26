package store.store_api.dto.users;

import java.time.LocalDateTime;

public record ResponseUserDTO(
        Long id,
        String username,
        String email,
        String cellphone,
        String cpf,
        LocalDateTime registrationDate,
        store.store_api.model.Addres addres
) {
}
