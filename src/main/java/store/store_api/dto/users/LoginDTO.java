package store.store_api.dto.users;

public record LoginDTO(
        String login,
        String password,
        String jwt) {
}
