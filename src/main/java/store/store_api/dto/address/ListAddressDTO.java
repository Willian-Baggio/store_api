package store.store_api.dto.address;

import store.store_api.model.Address;

public record ListAddressDTO(
        String id,
        String street,
        String neighborhood,
        String zipCode,
        String number,
        String complement,
        String city,
        String uf
) {
    public ListAddressDTO(Address address) {
        this(address.getId(), address.getStreet(), address.getNeighborhood(), address.getZipCode(),
                address.getNumber(), address.getComplement(), address.getCity(), address.getUf());
    }
}
