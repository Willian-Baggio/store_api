package store.store_api.controller;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import store.store_api.dto.productsSold.AlterProductSoldDTO;
import store.store_api.dto.productsSold.ProductSoldDTO;
import store.store_api.service.ProductsSoldService;

@RestController
@RequestMapping("products-sold")
public class ProductsSoldController {

    @Autowired
    private ProductsSoldService productsSoldService;

    @PostMapping
    public ResponseEntity<?> productSoldCreate(@RequestBody @Valid ProductSoldDTO productSoldDTO, UriComponentsBuilder uriBuilder) {
        try {
            var dto = productsSoldService.createProductSold(productSoldDTO);
            var uri = uriBuilder.path("/products-sold/{id}").buildAndExpand(dto.getId()).toUri();

            return ResponseEntity.created(uri).body(dto);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity alterProducSold(@RequestBody @Valid AlterProductSoldDTO alterProductSoldDTO) {
        try {
            var dto = productsSoldService.alterProductSold(alterProductSoldDTO);
            return ResponseEntity.ok(dto);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProductSold(@PathVariable Long id) {
        try {
            productsSoldService.deleteProductSold(id);
            return ResponseEntity.noContent().build();
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
