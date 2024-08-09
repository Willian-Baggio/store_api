package store.store_api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import store.store_api.dto.productsSold.AlterProductSoldDTO;
import store.store_api.dto.productsSold.ListProductSoldDTO;
import store.store_api.dto.productsSold.ProductSoldDTO;
import store.store_api.dto.productsSold.ResponseProductSoldDTO;
import store.store_api.exception.CustomValidationException;
import store.store_api.model.ProductsSold;
import store.store_api.repository.ProductsSoldRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductsSoldService {

    private final ProductsSoldRepository productsSoldRepository;
    private final DrinksService drinksService;
    private final FoodsService foodsService;
    private final SalesService salesService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<ListProductSoldDTO> listAllProductsSold() {
        List<ProductsSold> productsSoldList = productsSoldRepository.findAll();
        return productsSoldList.stream()
                .map(productsSold -> objectMapper.convertValue(productsSold, ListProductSoldDTO.class))
                .collect(Collectors.toList());
    }

    public ListProductSoldDTO listProductSale(String id) {
        var productsSold = findProductSoldById(id);
        return objectMapper.convertValue(productsSold, ListProductSoldDTO.class);
    }

    public ResponseProductSoldDTO productSoldCreate(ProductSoldDTO productSoldDTO) {
        var foods = foodsService.findFoodsById(productSoldDTO.foodsId());
        var drinks = drinksService.findDrinkById(productSoldDTO.drinksId());
        var sales = salesService.findSalesById(productSoldDTO.salesId());

        var productsSold = new ProductsSold(foods.getId(), drinks.getId(), sales.getId());
        var saveProductsSold = productsSoldRepository.save(productsSold);
        return objectMapper.convertValue(saveProductsSold, ResponseProductSoldDTO.class);
    }

    public AlterProductSoldDTO alterProductSold(AlterProductSoldDTO alterProductSoldDTO) {
        var productsSold = findProductSoldById(alterProductSoldDTO.id());
        var drinks = drinksService.findDrinkById(alterProductSoldDTO.drinksId());
        var foods = foodsService.findFoodsById(alterProductSoldDTO.foodsId());
        var sales = salesService.findSalesById(alterProductSoldDTO.salesId());

        productsSold.update(alterProductSoldDTO, foods.getId(), drinks.getId(), sales.getId());
        var saveProductsSold = productsSoldRepository.save(productsSold);
        return objectMapper.convertValue(saveProductsSold, AlterProductSoldDTO.class);
    }

    public void deleteProductSold(String id) {
        findProductSoldById(id);
        productsSoldRepository.deleteById(id);
    }

    public ProductsSold findProductSoldById(String id) {
        return productsSoldRepository.findById(id)
                .orElseThrow(() -> new CustomValidationException("Product Sold with ID " +
                        id + " does not exist."));
    }
}
