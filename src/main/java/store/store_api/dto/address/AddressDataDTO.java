package store.store_api.dto.address;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record AddressDataDTO(
    @NotBlank
    @Length(min = 5, max = 225)
    String street,

    @NotBlank
    @Length(min = 5, max = 225)
    String neighborhood,

    @NotBlank
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "Zip code must follow the pattern 12345-678")
    String zipCode,

    @NotBlank
    String number,

    @Length(min = 5, max = 225)
    String complement,

    @NotBlank
    @Length(min = 5, max = 225)
    String city,

    @NotBlank
    @Length(min = 2, max = 2)
    String uf
) {

    public String getZipCode() {
        return zipCode;
    }
}
