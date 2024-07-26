package store.store_api.controller;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.store_api.dto.addres.AlterAddresDTO;
import store.store_api.dto.users.AlterUserDTO;
import store.store_api.dto.users.ResponseUserDTO;
import store.store_api.dto.users.UserCreateDTO;
import store.store_api.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/{id}")
    public ResponseEntity listUser(@PathVariable Long id) {
        try {
            var users = usersService.listUser(id);
            return ResponseEntity.ok(users);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseUserDTO userRegister(@RequestBody @Valid UserCreateDTO userCreateDTO) {
        var dto = usersService.createUser(userCreateDTO);
        return new ResponseUserDTO(dto.getId(), dto.getUsername(), dto.getEmail(),
                dto.getCellphone(), dto.getCpf(), dto.getRegistrationDate(), dto.getAddres());
    }

    @PutMapping
    public AlterUserDTO alterUser(@RequestBody @Valid AlterUserDTO alterUserDTO) {
        var dto = usersService.alterUser(alterUserDTO);
        return new AlterUserDTO(dto.getId(), dto.getUsername(), dto.getEmail(),
                dto.getCellphone(), dto.getCpf(), new AlterAddresDTO(dto.getAddres()));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
    }
}
