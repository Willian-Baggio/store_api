package store.store_api.dto.addres;

import store.store_api.model.Addres;

public record ListAddresDTO(
        Long id,
        String street,
        String neighborhood,
        String zipCode,
        String number,
        String complement,
        String city,
        String uf
) {
    public ListAddresDTO(Addres addres) {
        this(addres.getId(), addres.getStreet(), addres.getNeighborhood(), addres.getZipCode(),
                addres.getNumber(), addres.getComplement(), addres.getCity(), addres.getUf());
    }
}
