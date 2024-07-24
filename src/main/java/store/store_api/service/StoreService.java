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

@Service
public class StoreService {

    @Autowired
    private StoresRepository storesRepository;

    @Autowired
    private AddresRepository addresRepository;

    public Stores createStore(StoreCreateDTO storeCreateDTO) {
        var addressDTO = storeCreateDTO.addres();
        var addres = new Addres(addressDTO);
        addres = addresRepository.save(addres);

        var stores = new Stores(storeCreateDTO.storeName(), addres);
        stores = storesRepository.save(stores);
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

    public ListStoreDTO listStore(Long id) {
        if (!storesRepository.existsById(id)) {
            throw new ValidacaoExcpetion("Store with ID " + id + " does not exist.");
        }
        var store = storesRepository.getReferenceById(id);
        return new ListStoreDTO(store);
    }
}
