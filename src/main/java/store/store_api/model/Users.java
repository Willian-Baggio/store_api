package store.store_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import store.store_api.dto.addres.AddresDataDTO;
import store.store_api.dto.users.UserCreateDTO;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Table(name = "users")
@Entity(name = "Users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String username;

    @JsonIgnore
    private String password;

    private String email;
    private String cellphone;
    private String cpf;
    private LocalDateTime registrationDate;

//    @Enumerated(EnumType.STRING)
//    private Roles roles;

    @ManyToOne(fetch = FetchType.LAZY)
    private Addres addres;

//    @OneToMany(fetch = FetchType.LAZY)
//    private List<Sales> sales;

    public Users(Users users) {
        this.id = users.getId();
        this.login = users.getLogin();
        this.username = users.getUsername();
        this.password = users.getPassword();
        this.email = users.getEmail();
        this.cellphone = users.getCellphone();
        this.cpf = users.getCpf();
        this.registrationDate = LocalDateTime.now();
        this.addres = users.getAddres();
    }

    public Users(String login, String username, String password, String email, String cellphone, String cpf, Addres addres) {
        this.login = login;
        this.username = username;
        this.password = password;
        this.email = email;
        this.cellphone = cellphone;
        this.cpf = cpf;
        this.addres = addres;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
