package store.store_api.dto.users;

import store.store_api.dto.address.ListAddressDTO;
import store.store_api.model.Users;

import java.time.LocalDateTime;

public record ListUserDTO(
        String id,
        String username,
        String email,
        String cellphone,
        String cpf,
        LocalDateTime registrationDate,
        ListAddressDTO address
) {
}
