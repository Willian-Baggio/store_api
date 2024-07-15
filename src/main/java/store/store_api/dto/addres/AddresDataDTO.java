package store.store_api.dto.addres;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import store.store_api.model.Addres;

public record AddresDataDTO(
    @NotBlank
    String street,

    @NotBlank
    String neighborhood,

    @NotBlank
    @Pattern(regexp = "\\d{8}")
    String zip_code,

    @NotBlank
    String number,

    String complement,

    @NotBlank
    String city,

    @NotBlank
    String uf
) {
    public AddresDataDTO(Addres addres) {
        this(addres.getStreet(), addres.getNeighborhood(), addres.getZip_code(), addres.getNumber(),
                addres.getComplement(), addres.getCity(), addres.getUf());
    }

    public String getZipCode() {
        return zip_code;
    }
}
