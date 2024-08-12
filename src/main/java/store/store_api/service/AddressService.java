package store.store_api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import store.store_api.dto.address.AddressDataDTO;
import store.store_api.dto.address.ListAddressDTO;
import store.store_api.dto.address.ResponseAddressDTO;
import store.store_api.exception.CustomValidationException;
import store.store_api.model.Address;
import store.store_api.repository.AddressRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<ListAddressDTO> listAllAddress() {
        List<Address> addresList = addressRepository.findAll();
        return addresList.stream()
                .map(address -> objectMapper.convertValue(address,  ListAddressDTO.class))
                .collect(Collectors.toList());
    }

    public ListAddressDTO listAddress(String id) {
        var address = findAddressById(id);
        return objectMapper.convertValue(address, ListAddressDTO.class);
    }

    public ResponseAddressDTO addressRegister(AddressDataDTO addressDataDTO){
        try {
            if (addressRepository.existsByZipCode(addressDataDTO.getZipCode())) {
                throw new CustomValidationException("CEP already registered");
            }

            var address = objectMapper.convertValue(addressDataDTO, Address.class);
            var saveAddress = addressRepository.save(address);
            return objectMapper.convertValue(saveAddress, ResponseAddressDTO.class);
        } catch (CustomValidationException e) {
            throw new CustomValidationException(e.getMessage());
        }
    }

    public void deleteAddress(String id) {
        findAddressById(id);
        addressRepository.deleteById(id);
    }

    public Address findAddressById(String id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new CustomValidationException("Address with ID " + id + " does not exist."));
    }
}
