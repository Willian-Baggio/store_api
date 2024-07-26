package store.store_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import store.store_api.dto.addres.AddresDataDTO;
import store.store_api.dto.addres.AlterAddresDTO;

@Table(name = "addres")
@Entity(name = "Addres")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Addres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String neighborhood;
    private String zipCode;
    private String number;
    private String complement;
    private String city;
    private String uf;

//    @OneToMany(fetch = FetchType.LAZY)
//    private List<Users> users;

    public Addres(AddresDataDTO data) {
        this.street = data.street();
        this.neighborhood = data.neighborhood();
        this.zipCode = data.zipCode();
        this.number = data.number();
        this.complement = data.complement();
        this.city = data.city();
        this.uf = data.uf();
    }

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

    public Addres(AlterAddresDTO alterAddresDTO) {
    }
}