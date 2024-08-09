package store.store_api.dto.address;

public record ResponseAddressDTO(
    String id,
    String street,
    String neighborhood,
    String zipCode,
    String number,
    String complement,
    String city,
    String uf
) {
}
