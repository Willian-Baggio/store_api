package store.store_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import store.store_api.dto.addres.AddresDataDTO;
import store.store_api.dto.addres.AlterAddresDTO;

@Document(collection = "addres")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Addres {

    @Id
    private String id;

    private String street;
    private String neighborhood;
    private String zipCode;
    private String number;
    private String complement;
    private String city;
    private String uf;

    public Addres(Addres addres) {
        this.id = addres.getId();
        this.street = addres.getStreet();
        this.neighborhood = addres.getNeighborhood();
        this.zipCode = addres.getZipCode();
        this.number = addres.getNumber();
        this.complement = addres.getComplement();
        this.city = addres.getCity();
        this.uf = addres.getUf();
    }

    public Addres(String street, String neighborhood, String zipCode, String number, String complement, String city, String uf) {
        this.street = street;
        this.neighborhood = neighborhood;
        this.zipCode = zipCode;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.uf = uf;
    }

    public Addres(AddresDataDTO addressDTO) {
        this.street = addressDTO.street();
        this.neighborhood = addressDTO.neighborhood();
        this.zipCode = addressDTO.getZipCode();
        this.number = addressDTO.number();
        this.complement = addressDTO.complement();
        this.city = addressDTO.city();
        this.uf = addressDTO.uf();
    }

    public void update(AlterAddresDTO alterAddresDTO) {
        if (alterAddresDTO.street() != null) {
            this.street = alterAddresDTO.street();
        }
        if (alterAddresDTO.neighborhood() != null) {
            this.neighborhood = alterAddresDTO.neighborhood();
        }
        if (alterAddresDTO.zipCode() != null) {
            this.zipCode = alterAddresDTO.zipCode();
        }
        if (alterAddresDTO.number() != null) {
            this.number = alterAddresDTO.number();
        }
        if (alterAddresDTO.city() != null) {
            this.city = alterAddresDTO.city();
        }
        if (alterAddresDTO.uf() != null) {
            this.uf = alterAddresDTO.uf();
        }
    }
}