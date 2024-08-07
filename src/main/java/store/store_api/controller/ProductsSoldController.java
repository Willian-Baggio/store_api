package store.store_api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import store.store_api.dto.productsSold.AlterProductSoldDTO;
import store.store_api.dto.productsSold.ListProductSoldDTO;
import store.store_api.dto.productsSold.ProductSoldDTO;
import store.store_api.dto.productsSold.ResponseProductSoldDTO;
import store.store_api.service.ProductsSoldService;

import java.util.List;

@RestController
@RequestMapping("/products-sold")
@AllArgsConstructor
public class ProductsSoldController {

    private final ProductsSoldService productsSoldService;

    @GetMapping("/{id}")
    public ListProductSoldDTO listProductSale(@PathVariable String id) {
        return productsSoldService.listProductSale(id);
    }

    @GetMapping
    public List<ListProductSoldDTO> listAllProducts() {
        return productsSoldService.listAllProductsSold();
    }

    @PostMapping
    public ResponseProductSoldDTO productSoldCreate(@RequestBody @Valid ProductSoldDTO productSoldDTO) {
        return  productsSoldService.productSoldCreate(productSoldDTO);
    }

    @PutMapping
    public AlterProductSoldDTO alterProductSold(@RequestBody @Valid AlterProductSoldDTO alterProductSoldDTO) {
        return productsSoldService.alterProductSold(alterProductSoldDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProductSold(@PathVariable String id) {
        productsSoldService.deleteProductSold(id);
    }
}
