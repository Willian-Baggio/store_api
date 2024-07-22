package store.store_api.dto.addres;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import store.store_api.model.Addres;

public record AlterAddresDTO(
        @NotBlank
        Long id,

        @NotBlank
        String street,

        @NotBlank
        String neighborhood,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String zipCode,

        @NotBlank
        String number,

        String complement,

        @NotBlank
        String city,

        @NotBlank
        String uf
) {
    public AlterAddresDTO(Addres addres) {
        this(addres.getId(), addres.getStreet(), addres.getNeighborhood(), addres.getZipCode(),
                addres.getNumber(), addres.getComplement(), addres.getCity(), addres.getUf());
    }
}
