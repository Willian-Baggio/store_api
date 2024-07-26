package store.store_api.dto.addres;

public record ResponseAddresDTO(
    String street,
    String neighborhood,
    String zipCode,
    String number,
    String complement,
    String city,
    String uf
) {
}
