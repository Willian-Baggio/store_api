package store.store_api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.store_api.dto.users.LoginDTO;
import store.store_api.model.Users;
import store.store_api.security.TokenService;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid LoginDTO userDTO) {
        var token = new UsernamePasswordAuthenticationToken(userDTO.login(), userDTO.password());
        var authentication = manager.authenticate(token);

        return ResponseEntity.ok(tokenService.gerarToken((Users) authentication.getPrincipal()));
    }
}
