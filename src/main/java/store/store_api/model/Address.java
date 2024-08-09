package store.store_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import store.store_api.dto.address.AddressDataDTO;
import store.store_api.dto.address.AlterAddressDTO;

@Document(collection = "address")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    private String id;

    private String street;
    private String neighborhood;
    private String zipCode;
    private String number;
    private String complement;
    private String city;
    private String uf;

    public Address(Address address) {
        this.id = address.getId();
        this.street = address.getStreet();
        this.neighborhood = address.getNeighborhood();
        this.zipCode = address.getZipCode();
        this.number = address.getNumber();
        this.complement = address.getComplement();
        this.city = address.getCity();
        this.uf = address.getUf();
    }

    public Address(String street, String neighborhood, String zipCode, String number, String complement, String city, String uf) {
        this.street = street;
        this.neighborhood = neighborhood;
        this.zipCode = zipCode;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.uf = uf;
    }

    public Address(AddressDataDTO addressDTO) {
        this.street = addressDTO.street();
        this.neighborhood = addressDTO.neighborhood();
        this.zipCode = addressDTO.getZipCode();
        this.number = addressDTO.number();
        this.complement = addressDTO.complement();
        this.city = addressDTO.city();
        this.uf = addressDTO.uf();
    }

    public void update(AlterAddressDTO addressDataDTO) {
        if (addressDataDTO.street() != null) {
            this.street = addressDataDTO.street();
        }
        if (addressDataDTO.neighborhood() != null) {
            this.neighborhood = addressDataDTO.neighborhood();
        }
        if (addressDataDTO.zipCode() != null) {
            this.zipCode = addressDataDTO.zipCode();
        }
        if (addressDataDTO.number() != null) {
            this.number = addressDataDTO.number();
        }
        if (addressDataDTO.city() != null) {
            this.city = addressDataDTO.city();
        }
        if (addressDataDTO.uf() != null) {
            this.uf = addressDataDTO.uf();
        }
    }
}