package store.store_api.dto.address;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDataDTO(
    @NotBlank
    String street,

    @NotBlank
    String neighborhood,

    @NotBlank
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "Zip code must follow the pattern 12345-678")
    String zipCode,

    @NotBlank
    String number,

    String complement,

    @NotBlank
    String city,

    @NotBlank
    String uf
) {

    public String getZipCode() {
        return zipCode;
    }
}
