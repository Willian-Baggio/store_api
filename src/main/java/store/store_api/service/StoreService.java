package store.store_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.store_api.dto.stores.AlterStoreDTO;
import store.store_api.dto.stores.ListStoreDTO;
import store.store_api.dto.stores.StoreCreateDTO;
import store.store_api.exception.ValidacaoExcpetion;
import store.store_api.model.Addres;
import store.store_api.model.Stores;
import store.store_api.repository.AddresRepository;
import store.store_api.repository.StoresRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService {

    @Autowired
    private StoresRepository storesRepository;

    @Autowired
    private AddresRepository addresRepository;

    public List<ListStoreDTO> listAllStores() {
        List<Stores> storesList = storesRepository.findAll();
        return storesList.stream()
                .map(ListStoreDTO::new)
                .collect(Collectors.toList());
    }

    public Stores createStore(StoreCreateDTO storeCreateDTO) {
        var addressDTO = storeCreateDTO.addres();
        var addres = new Addres(addressDTO.street(), addressDTO.neighborhood(),
                addressDTO.zipCode(), addressDTO.number(), addressDTO.complement(),
                addressDTO.city(), addressDTO.uf());
        addres = addresRepository.save(addres);

        var stores = new Stores(storeCreateDTO.storeName(), addres);
        return storesRepository.save(stores);
    }

    public Stores alterStore(AlterStoreDTO alterStoreDTO) {
        if (!storesRepository.existsById(alterStoreDTO.id())) {
            throw new ValidacaoExcpetion("Store with ID " + alterStoreDTO.id() + " does not exist.");
        }
        var stores = storesRepository.getReferenceById(alterStoreDTO.id());
        stores.update(alterStoreDTO);
        return storesRepository.save(stores);
    }

    public void deleteStore(Long id) {
        if (!storesRepository.existsById(id)) {
            throw new ValidacaoExcpetion("Store with ID " + id + " does not exist.");
        }
        storesRepository.deleteById(id);
    }

    public ListStoreDTO listStore(Long id) {
        if (!storesRepository.existsById(id)) {
            throw new ValidacaoExcpetion("Store with ID " + id + " does not exist.");
        }
        var store = storesRepository.getReferenceById(id);
        Addres addres = store.getAddres();

        if (addres != null) {
            addres.getCity();
        }

        return new ListStoreDTO(store);
    }

}
