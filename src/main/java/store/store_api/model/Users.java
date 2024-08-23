package store.store_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import store.store_api.dto.users.AlterUserDTO;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Document(collection = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Users implements UserDetails {

    @Id
    private String id;

    private String login;
    private String username;

    @JsonIgnore
    private String password;

    private String email;
    private String cellphone;
    private String cpf;
    private LocalDateTime registrationDate;

    private Address address;

    public void update(AlterUserDTO alterUserDTO) {
        if (alterUserDTO.username() != null) {
            this.username = alterUserDTO.username();
        }
        if (alterUserDTO.email() != null) {
            this.email = alterUserDTO.email();
        }
        if (alterUserDTO.cellphone() != null) {
            this.cellphone = alterUserDTO.cellphone();
        }
        if (alterUserDTO.cpf() != null) {
            this.cpf = alterUserDTO.cpf();
        }
        if (alterUserDTO.address() != null) {
            this.address.update(alterUserDTO.address());
        }
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
