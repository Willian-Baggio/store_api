package store.store_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.store_api.dto.stores.AlterStoreDTO;
import store.store_api.dto.stores.StoreCreateDTO;
import store.store_api.exception.ValidacaoExcpetion;
import store.store_api.model.Stores;
import store.store_api.repository.StoresRepository;

@Service
public class StoreService {

    @Autowired
    private StoresRepository storesRepository;

    public Stores createStore(StoreCreateDTO storeCreateDTO) {
        var stores = new Stores(storeCreateDTO);
        storesRepository.save(stores);
        return new Stores(stores);
    }

    public AlterStoreDTO alterStore(AlterStoreDTO alterStoreDTO) {
        if (!storesRepository.existsById(alterStoreDTO.id())) {
            throw new ValidacaoExcpetion("Store with ID " + alterStoreDTO.id() + " does not exist.");
        }
        var stores = new Stores(alterStoreDTO);
        storesRepository.save(stores);
        return new AlterStoreDTO(stores);
    }

    public void deleteStore(Long id) {
        if (!storesRepository.existsById(id)) {
            throw new ValidacaoExcpetion("Store with ID " + id + " does not exist.");
        }
        storesRepository.deleteById(id);
    }

}
