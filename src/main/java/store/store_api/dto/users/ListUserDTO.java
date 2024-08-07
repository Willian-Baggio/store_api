package store.store_api.dto.users;

import store.store_api.dto.address.ListAddressDTO;
import store.store_api.model.Users;

public record ListUserDTO(
        String id,
        String username,
        String email,
        String cellphone,
        String cpf,
        ListAddressDTO address
) {
}
