package store.store_api.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Table(name = "permissions")
@Entity(name = "Permissions")
@EqualsAndHashCode(of = "id")
public class Permissions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String permissionName;
}
