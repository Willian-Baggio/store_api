package store.store_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import store.store_api.dto.address.AddressDataDTO;
import store.store_api.dto.address.AlterAddressDTO;
import store.store_api.dto.address.ListAddressDTO;
import store.store_api.dto.address.ResponseAddressDTO;
import store.store_api.model.Address;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    ListAddressDTO toListAddressDTO(Address address);
    Address toAddressDataDTO(AddressDataDTO addressDataDTO);
    ResponseAddressDTO toResponseAddressDTO(Address address);
    AlterAddressDTO toAlterAddressDTO(Address address);
}
