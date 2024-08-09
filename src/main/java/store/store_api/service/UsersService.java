package store.store_api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import store.store_api.dto.users.AlterUserDTO;
import store.store_api.dto.users.ListUserDTO;
import store.store_api.dto.users.ResponseUserDTO;
import store.store_api.dto.users.UserCreateDTO;
import store.store_api.exception.CustomValidationException;
import store.store_api.model.Address;
import store.store_api.model.Users;
import store.store_api.repository.AddressRepository;
import store.store_api.repository.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;
    private final AddressRepository addressRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<ListUserDTO> listAllUsers() {
        List<Users> usersList = usersRepository.findAll();
        return usersList.stream()
                .map(users -> objectMapper.convertValue(users, ListUserDTO.class))
                .collect(Collectors.toList());
    }

    public ListUserDTO listUser(String id) {
        var user = findUserById(id);
        Address address = user.getAddress();

        if (address != null) {
            address.getCity();
        }

        return objectMapper.convertValue(user, ListUserDTO.class);
    }

    public ResponseUserDTO userRegister(UserCreateDTO userCreateDTO) {
        var addressDTO = userCreateDTO.address();
        var address = objectMapper.convertValue(addressDTO, Address.class);
        address = addressRepository.save(address);

        var encryptedPassword = bCryptPasswordEncoder.encode(userCreateDTO.password());
        var users = new Users(userCreateDTO.login(), userCreateDTO.username(), encryptedPassword, userCreateDTO.email(),
                userCreateDTO.cellphone(), userCreateDTO.cpf(), address);
        users = usersRepository.save(users);
        return objectMapper.convertValue(users, ResponseUserDTO.class);
    }

    public AlterUserDTO alterUser(AlterUserDTO alterUserDTO) {
        var users = findUserById(alterUserDTO.id());
        users.update(alterUserDTO);
        var saveUsers = usersRepository.save(users);
        return objectMapper.convertValue(saveUsers, AlterUserDTO.class);
    }

    public void deleteUser(String id) {
        findUserById(id);
        usersRepository.deleteById(id);
    }

    public Users findUserById(String id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new CustomValidationException("User with ID " + id + " does not exist."));
    }
}
