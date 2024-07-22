package store.store_api.controller;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import store.store_api.dto.stores.AlterStoreDTO;
import store.store_api.dto.stores.StoreCreateDTO;
import store.store_api.service.StoreService;

@RestController
@RequestMapping("store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping
    public ResponseEntity storeCreate(@RequestBody @Valid StoreCreateDTO storeCreateDTO, UriComponentsBuilder uriBuilder) {
        try {
            var dto = storeService.createStore(storeCreateDTO);
            var uri = uriBuilder.path("/store/{id}").buildAndExpand(dto.getId()).toUri();

            return ResponseEntity.created(uri).body(dto);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity alterStore(@RequestBody @Valid AlterStoreDTO alterStoreDTO) {
        try {
            var dto = storeService.alterStore(alterStoreDTO);
            return ResponseEntity.ok(dto);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStore(@PathVariable Long id) {
        try {
            storeService.deleteStore(id);
            return ResponseEntity.ok("Store delete");
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
