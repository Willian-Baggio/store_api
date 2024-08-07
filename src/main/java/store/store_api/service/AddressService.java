package store.store_api.service;

import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import store.store_api.dto.address.AddressDataDTO;
import store.store_api.dto.address.ListAddressDTO;
import store.store_api.dto.address.ResponseAddressDTO;
import store.store_api.mapper.AddressMapper;
import store.store_api.model.Address;
import store.store_api.repository.AddressRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper = AddressMapper.INSTANCE;

    public List<ListAddressDTO> listAllAddress() {
        List<Address> addresList = addressRepository.findAll();
        return addresList.stream()
                .map(addressMapper::toListAddressDTO)
                .collect(Collectors.toList());
    }

    public ListAddressDTO listAddress(String id) {
        var address = findAddressById(id);
        return addressMapper.toListAddressDTO(address);
    }

    public ResponseAddressDTO addressRegister(AddressDataDTO addressDataDTO){
        if (addressRepository.existsByZipCode(addressDataDTO.getZipCode())) {
            throw new ValidationException("CEP already registered");
        }

        var address = addressMapper.toAddressDataDTO(addressDataDTO);
        var saveAddress = addressRepository.save(address);
        return addressMapper.toResponseAddressDTO(saveAddress);
    }

    public void deleteAddress(String id) {
        findAddressById(id);
        addressRepository.deleteById(id);
    }

    public Address findAddressById(String id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new ValidationException("Address with ID " + id + " does not exist."));
    }
}
