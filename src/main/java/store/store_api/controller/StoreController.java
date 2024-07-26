package store.store_api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import store.store_api.dto.addres.AlterAddresDTO;
import store.store_api.dto.stores.AlterStoreDTO;
import store.store_api.dto.stores.ListStoreDTO;
import store.store_api.dto.stores.ResponseStoreDTO;
import store.store_api.dto.stores.StoreCreateDTO;
import store.store_api.service.StoreService;

@RestController
@RequestMapping("store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/{id}")
    public ListStoreDTO listStore(@PathVariable Long id) {
        var stores = storeService.listStore(id);
        return stores;
    }

    @PostMapping
    public ResponseStoreDTO createStore(@RequestBody @Valid StoreCreateDTO storeCreateDTO) {
        var dto = storeService.createStore(storeCreateDTO);
        return new ResponseStoreDTO(dto.getId(), dto.getStoreName(), dto.getAddres());
    }

    @PutMapping
    public AlterStoreDTO alterStore(@RequestBody @Valid AlterStoreDTO alterStoreDTO) {
        var dto = storeService.alterStore(alterStoreDTO);
        return new AlterStoreDTO(dto.getId(), dto.getStoreName(), new AlterAddresDTO(dto.getAddres()));
    }

    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);
    }
}
