package store.store_api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import store.store_api.dto.stores.AlterStoreDTO;
import store.store_api.dto.stores.ListStoreDTO;
import store.store_api.dto.stores.ResponseStoreDTO;
import store.store_api.dto.stores.StoreCreateDTO;
import store.store_api.exception.CustomValidationException;
import store.store_api.model.Address;
import store.store_api.model.Stores;
import store.store_api.repository.AddressRepository;
import store.store_api.repository.StoresRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StoreService {

    private final StoresRepository storesRepository;
    private final AddressRepository addressRepository;
    private final ObjectMapper objectMapper;

    public ListStoreDTO listStore(String id) {
        var store = findStoresById(id);
        Address address = store.getAddress();

        if (address != null) {
            address.getCity();
        }

        return objectMapper.convertValue(store, ListStoreDTO.class);
    }

    public List<ListStoreDTO> listAllStores() {
        List<Stores> storesList = storesRepository.findAll();
        return storesList.stream()
                .map(stores -> objectMapper.convertValue(stores, ListStoreDTO.class))
                .collect(Collectors.toList());
    }

    public ResponseStoreDTO createStore(StoreCreateDTO storeCreateDTO) {
        try {
            var addressDTO = storeCreateDTO.address();
            var address = objectMapper.convertValue(addressDTO, Address.class);
            address = addressRepository.save(address);

            var stores = new Stores(storeCreateDTO.storeName(), address);
            var saveStores = storesRepository.save(stores);
            return objectMapper.convertValue(saveStores, ResponseStoreDTO.class);
        } catch (CustomValidationException e) {
            throw new CustomValidationException(e.getMessage());
        }
    }

    public AlterStoreDTO alterStore(AlterStoreDTO alterStoreDTO) {
        try {
            var stores = findStoresById(alterStoreDTO.id());
            stores.update(alterStoreDTO);
            var updateStores = storesRepository.save(stores);
            return objectMapper.convertValue(updateStores, AlterStoreDTO.class);
        } catch (CustomValidationException e) {
            throw new CustomValidationException(e.getMessage());
        }
    }

    public void deleteStore(String id) {
        findStoresById(id);
        storesRepository.deleteById(id);
    }

    public Stores findStoresById(String id) {
        return storesRepository.findById(id)
                .orElseThrow(() -> new CustomValidationException("Store with ID "
                        + id + " does not exist."));
    }
}
