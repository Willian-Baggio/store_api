package store.store_api.controller;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import store.store_api.dto.sales.AlterSalesDTO;
import store.store_api.dto.sales.SalesDTO;
import store.store_api.service.SalesService;

@RestController
@RequestMapping("sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @PostMapping
    public ResponseEntity salesRegister(@RequestBody @Valid SalesDTO salesDTO, UriComponentsBuilder uriBuilder) {
        try {
            var dto = salesService.createSales(salesDTO);
            var uri = uriBuilder.path("/sales/{id}").buildAndExpand(dto.getId()).toUri();

            return ResponseEntity.created(uri).body(dto);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity alterSales(@RequestBody @Valid AlterSalesDTO alterSalesDTO) {
        try {
            var dto = salesService.alterSales(alterSalesDTO);
            return ResponseEntity.ok(dto);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSales(@PathVariable Long id) {
        try {
            salesService.deleteSales(id);
            return ResponseEntity.noContent().build();
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
