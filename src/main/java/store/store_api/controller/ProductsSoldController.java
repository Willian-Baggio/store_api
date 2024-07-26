package store.store_api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import store.store_api.dto.productsSold.AlterProductSoldDTO;
import store.store_api.dto.productsSold.ProductSoldDTO;
import store.store_api.dto.productsSold.ResponseProductSoldDTO;
import store.store_api.service.ProductsSoldService;

@RestController
@RequestMapping("products-sold")
public class ProductsSoldController {

    @Autowired
    private ProductsSoldService productsSoldService;

    @PostMapping
    public ResponseProductSoldDTO productSoldCreate(@RequestBody @Valid ProductSoldDTO productSoldDTO) {
        var dto = productsSoldService.createProductSold(productSoldDTO);
        return new ResponseProductSoldDTO(dto.getFoods(), dto.getDrinks(),
                dto.getSales());
    }

    @PutMapping
    public AlterProductSoldDTO alterProducSold(@RequestBody @Valid AlterProductSoldDTO alterProductSoldDTO) {
        var dto = productsSoldService.alterProductSold(alterProductSoldDTO);
        return new AlterProductSoldDTO(dto.getId(), dto.getFoods(), dto.getDrinks(),
                dto.getSales());
    }

    @DeleteMapping("/{id}")
    public void deleteProductSold(@PathVariable Long id) {
        productsSoldService.deleteProductSold(id);
    }
}
