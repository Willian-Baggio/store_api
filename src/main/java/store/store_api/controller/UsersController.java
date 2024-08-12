package store.store_api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import store.store_api.dto.users.AlterUserDTO;
import store.store_api.dto.users.ListUserDTO;
import store.store_api.dto.users.ResponseUserDTO;
import store.store_api.dto.users.UserCreateDTO;
import store.store_api.service.UsersService;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Validated
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/{id}")
    public ListUserDTO listUser(@PathVariable String id) {
        return usersService.listUser(id);
    }

    @GetMapping
    public List<ListUserDTO> listAllUsers() {
        return usersService.listAllUsers();
    }

    @PostMapping
    public ResponseUserDTO userRegister(@RequestBody @Valid UserCreateDTO userCreateDTO) {
        return usersService.userRegister(userCreateDTO);
    }

    @PutMapping
    public AlterUserDTO alterUser(@RequestBody @Valid AlterUserDTO alterUserDTO) {
        return usersService.alterUser(alterUserDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        usersService.deleteUser(id);
    }
}
