package store.store_api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.store_api.dto.users.LoginDTO;
import store.store_api.model.Users;
import store.store_api.security.TokenService;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager manager;

    private final TokenService tokenService;

    @PostMapping
    public LoginDTO login(@RequestBody @Valid LoginDTO userDTO) {
        var token = new UsernamePasswordAuthenticationToken(userDTO.login(), userDTO.password());
        var authentication = manager.authenticate(token);
        var jwt = tokenService.generateToken((UserDetails) authentication.getPrincipal());

        return new LoginDTO(userDTO.login(), userDTO.password(), jwt);
    }
}
