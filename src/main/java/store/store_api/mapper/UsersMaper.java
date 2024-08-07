package store.store_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import store.store_api.dto.users.AlterUserDTO;
import store.store_api.dto.users.ListUserDTO;
import store.store_api.dto.users.ResponseUserDTO;
import store.store_api.dto.users.UserCreateDTO;
import store.store_api.model.Users;

@Mapper
public interface UsersMaper {
    UsersMaper INSTANCE = Mappers.getMapper(UsersMaper.class);

    ListUserDTO toListUserDTO(Users users);
    Users toUserCreateDTO(UserCreateDTO userCreateDTO);
    ResponseUserDTO toResponseUserDTO(Users users);
    AlterUserDTO toAlterUserDTO(Users users);
}
