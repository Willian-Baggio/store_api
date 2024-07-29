package store.store_api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import store.store_api.dto.addres.AlterAddresDTO;
import store.store_api.dto.users.AlterUserDTO;
import store.store_api.dto.users.ListUserDTO;
import store.store_api.dto.users.ResponseUserDTO;
import store.store_api.dto.users.UserCreateDTO;
import store.store_api.service.UsersService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/{id}")
    public ListUserDTO listUser(@PathVariable Long id) {
        return usersService.listUser(id);
    }

    @GetMapping
    public List<ListUserDTO> listAllUsers() {
        return usersService.listAllUsers();
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
