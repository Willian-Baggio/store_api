package store.store_api.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import store.store_api.dto.stores.AlterStoreDTO;
import store.store_api.dto.stores.ListStoreDTO;
import store.store_api.dto.stores.ResponseStoreDTO;
import store.store_api.dto.stores.StoreCreateDTO;
import store.store_api.mapper.AddressMapper;
import store.store_api.mapper.StoreMapper;
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
    private final StoreMapper storeMapper = StoreMapper.INSTANCE;
    private final AddressMapper addressMapper = AddressMapper.INSTANCE;
    private final AddressRepository addressRepository;

    public ListStoreDTO listStore(String id) {
        var store = findStoresById(id);
        Address address = store.getAddress();

        if (address != null) {
            address.getCity();
        }

        return storeMapper.toListStoreDTO(store);
    }

    public List<ListStoreDTO> listAllStores() {
        List<Stores> storesList = storesRepository.findAll();
        return storesList.stream()
                .map(storeMapper::toListStoreDTO)
                .collect(Collectors.toList());
    }

    public ResponseStoreDTO createStore(StoreCreateDTO storeCreateDTO) {
        var addressDTO = storeCreateDTO.addres();
        var address = addressMapper.toAddressDataDTO(addressDTO);
        address = addressRepository.save(address);

        var stores = new Stores(storeCreateDTO.storeName(), address);
        var saveStores = storesRepository.save(stores);
        return storeMapper.toResponseStoreDTO(saveStores);
    }

    public AlterStoreDTO alterStore(AlterStoreDTO alterStoreDTO) {
        var stores = findStoresById(alterStoreDTO.id());
        stores.update(alterStoreDTO);
        return storeMapper.toAlterStoreDTO(stores);
    }

    public void deleteStore(String id) {
        findStoresById(id);
        storesRepository.deleteById(id);
    }

    public Stores findStoresById(String id) {
        return storesRepository.findById(id)
                .orElseThrow(() -> new jakarta.validation.ValidationException("Store with ID "
                        + id + " does not exist."));
    }
}
