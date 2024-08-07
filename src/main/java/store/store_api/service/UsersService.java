package store.store_api.service;

import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import store.store_api.dto.users.AlterUserDTO;
import store.store_api.dto.users.ListUserDTO;
import store.store_api.dto.users.ResponseUserDTO;
import store.store_api.dto.users.UserCreateDTO;
import store.store_api.mapper.AddressMapper;
import store.store_api.mapper.UsersMaper;
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
    private final AddressRepository addresRepository;
    private final UsersMaper usersMaper = UsersMaper.INSTANCE;
    private final AddressMapper addressMapper = AddressMapper.INSTANCE;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<ListUserDTO> listAllUsers() {
        List<Users> usersList = usersRepository.findAll();
        return usersList.stream()
                .map(usersMaper::toListUserDTO)
                .collect(Collectors.toList());
    }

    public ListUserDTO listUser(String id) {
        var user = findUserById(id);
        Address address = user.getAddress();

        if (address != null) {
            address.getCity();
        }

        return usersMaper.toListUserDTO(user);
    }

    public ResponseUserDTO userRegister(UserCreateDTO userCreateDTO) {
        var addressDTO = userCreateDTO.address();
        var address = new Address(addressDTO);
        address = addresRepository.save(address);

        var encryptedPassword = bCryptPasswordEncoder.encode(userCreateDTO.password());
        var users = new Users(userCreateDTO.login() ,userCreateDTO.username(), encryptedPassword, userCreateDTO.email(),
                userCreateDTO.cellphone(), userCreateDTO.cpf(), address);
        users = usersRepository.save(users);
        return usersMaper.toResponseUserDTO(users);
    }

    public AlterUserDTO alterUser(AlterUserDTO alterUserDTO) {
        var users = findUserById(alterUserDTO.id());
        users.update(alterUserDTO);
        return usersMaper.toAlterUserDTO(users);
    }

    public void deleteUser(String id) {
        findUserById(id);
        usersRepository.deleteById(id);
    }

    public Users findUserById(String id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new ValidationException("Users with ID " + id + " does not exist."));
    }
}
