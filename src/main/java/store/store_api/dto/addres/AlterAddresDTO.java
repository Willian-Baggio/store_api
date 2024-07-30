package store.store_api.dto.addres;

import jakarta.validation.constraints.NotBlank;
import store.store_api.model.Addres;

public record AlterAddresDTO(
        @NotBlank
        String id,
        String street,
        String neighborhood,
        String zipCode,
        String number,
        String complement,
        String city,
        String uf
) {
    public AlterAddresDTO(Addres addres) {
        this(addres.getId(), addres.getStreet(), addres.getNeighborhood(), addres.getZipCode(),
                addres.getNumber(), addres.getComplement(), addres.getCity(), addres.getUf());
    }
}
