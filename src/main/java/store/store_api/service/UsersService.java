package store.store_api.service;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import store.store_api.dto.users.AlterUserDTO;
import store.store_api.dto.users.ListUserDTO;
import store.store_api.dto.users.UserCreateDTO;
import store.store_api.model.Addres;
import store.store_api.model.Users;
import store.store_api.repository.AddresRepository;
import store.store_api.repository.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AddresRepository addresRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<ListUserDTO> listAllUsers() {
        List<Users> usersList = usersRepository.findAll();
        return usersList.stream()
                .map(ListUserDTO::new)
                .collect(Collectors.toList());
    }

    public Users createUser(UserCreateDTO userCreateDTO) {
        var addressDTO = userCreateDTO.addres();
        var addres = new Addres(addressDTO);
        addres = addresRepository.save(addres);

        var encryptedPassword = bCryptPasswordEncoder.encode(userCreateDTO.password());
        var users = new Users(userCreateDTO.login() ,userCreateDTO.username(), encryptedPassword, userCreateDTO.email(),
                userCreateDTO.cellphone(), userCreateDTO.cpf(), addres);
        users = usersRepository.save(users);
        return new Users(users);
    }

    public Users alterUser(AlterUserDTO alterUserDTO) {
        if (!usersRepository.existsById(alterUserDTO.id())) {
            throw new ValidationException("User with ID " + alterUserDTO.id() + " does not exist.");
        }
        var users = usersRepository.getReferenceById(alterUserDTO.id());
        users.update(alterUserDTO);
        return usersRepository.save(users);
    }

    public void deleteUser(Long id) {
        if (!usersRepository.existsById(id)) {
            throw new ValidationException("User with ID " + id + " does not exist.");
        }
        usersRepository.deleteById(id);
    }

    public ListUserDTO listUser(Long id) {
        if (!usersRepository.existsById(id)) {
            throw new ValidationException("User with ID " + id + " does not exist.");
        }
        var user = usersRepository.getReferenceById(id);
        Addres addres = user.getAddres();

        if (addres != null) {
            addres.getCity();
        }

        return new ListUserDTO(user);
    }

}
