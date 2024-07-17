package store.store_api.service;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.store_api.dto.users.AlterUserDTO;
import store.store_api.model.Users;
import store.store_api.repository.UsersRepository;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public void alterUser(AlterUserDTO alterUserDTO) {
        if (!usersRepository.existsById(alterUserDTO.id())) {
            throw new ValidationException("User with ID " + alterUserDTO.id() + " does not exist.");
        }
        Users users = new Users();
        usersRepository.save(users);
    }

    public void deleteUser(Long id) {
        if (!usersRepository.existsById(id)) {
            throw new ValidationException("User with ID " + id + " does not exist.");
        }
        usersRepository.deleteById(id);
    }
}
