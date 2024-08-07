package store.store_api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import store.store_api.dto.address.AlterAddressDTO;
import store.store_api.dto.stores.AlterStoreDTO;
import store.store_api.dto.stores.ListStoreDTO;
import store.store_api.dto.stores.ResponseStoreDTO;
import store.store_api.dto.stores.StoreCreateDTO;
import store.store_api.service.StoreService;

import java.util.List;

@RestController
@RequestMapping("/store")
@AllArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/{id}")
    public ListStoreDTO listStore(@PathVariable String id) {
        return storeService.listStore(id);
    }

    @GetMapping
    public List<ListStoreDTO> listAllStores() {
        return storeService.listAllStores();
    }

    @PostMapping
    public ResponseStoreDTO createStore(@RequestBody @Valid StoreCreateDTO storeCreateDTO) {
        return storeService.createStore(storeCreateDTO);
    }

    @PutMapping
    public AlterStoreDTO alterStore(@RequestBody @Valid AlterStoreDTO alterStoreDTO) {
        return storeService.alterStore(alterStoreDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable String id) {
        storeService.deleteStore(id);
    }
}
