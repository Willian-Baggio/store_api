package store.store_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import store.store_api.dto.addres.AddresDataDTO;
import store.store_api.dto.addres.AlterAddresDTO;

import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY)
    private List<Users> users;

    @OneToOne(fetch = FetchType.LAZY)
    private Stores store;

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
    }

    public Addres(AlterAddresDTO alterAddresDTO) {
    }
}