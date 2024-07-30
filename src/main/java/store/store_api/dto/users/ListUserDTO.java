package store.store_api.dto.users;

import store.store_api.dto.addres.ListAddresDTO;
import store.store_api.model.Users;

public record ListUserDTO(
        String id,
        String username,
        String email,
        String cellphone,
        String cpf,
        ListAddresDTO addres
) {
    public ListUserDTO(Users users) {
        this(users.getId(), users.getUsername(), users.getEmail(), users.getCellphone(),
                users.getCpf(), new ListAddresDTO(users.getAddres()));
    }
}
