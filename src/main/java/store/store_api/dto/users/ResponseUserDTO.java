package store.store_api.dto.users;

import store.store_api.model.Address;

import java.time.LocalDateTime;

public record ResponseUserDTO(
        String id,
        String username,
        String email,
        String cellphone,
        String cpf,
        LocalDateTime registrationDate,
        Address address
) {
}
