package store.store_api.service;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.store_api.dto.productsSold.AlterProductSoldDTO;
import store.store_api.dto.productsSold.ListProductSoldDTO;
import store.store_api.dto.productsSold.ProductSoldDTO;
import store.store_api.exception.ValidacaoExcpetion;
import store.store_api.model.ProductsSold;
import store.store_api.repository.DrinksRepository;
import store.store_api.repository.FoodsRepository;
import store.store_api.repository.ProductsSoldRepository;
import store.store_api.repository.SalesRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsSoldService {

    @Autowired
    private ProductsSoldRepository productsSoldRepository;

    @Autowired
    private DrinksRepository drinksRepository;

    @Autowired
    private FoodsRepository foodsRepository;

    @Autowired
    private SalesRepository salesRepository;

    public List<ListProductSoldDTO> listAllProductsSold() {
        List<ProductsSold> productsSoldList = productsSoldRepository.findAll();
        return productsSoldList.stream()
                .map(ListProductSoldDTO::new)
                .collect(Collectors.toList());
    }

    public ListProductSoldDTO listProductSale(String id) {
        var productsSold = productsSoldRepository.findById(id)
                .orElseThrow(() -> new ValidationException("Product Sold with ID " + id + " does not exist."));
        return new ListProductSoldDTO(productsSold);
    }

    public ProductsSold createProductSold(ProductSoldDTO productSoldDTO) {
        var foods = foodsRepository.findById(productSoldDTO.foodsId())
                .orElseThrow(() -> new ValidationException("Product sold food with ID "
                        + productSoldDTO.foodsId() + " does not exist."));
        var drinks = drinksRepository.findById(productSoldDTO.drinksId())
                .orElseThrow(() -> new ValidationException("Product sold drinks with ID "
                        + productSoldDTO.drinksId() + " does not exist."));
        var sales = salesRepository.findById(productSoldDTO.salesId())
                .orElseThrow(() -> new ValidationException("Sale with ID "
                        + productSoldDTO.salesId() + " does not exist."));

        var productsSold = new ProductsSold(foods.getId(), drinks.getId(), sales.getId());
        return productsSoldRepository.save(productsSold);
    }

    public ProductsSold alterProductSold(AlterProductSoldDTO alterProductSoldDTO) {
        if (!productsSoldRepository.existsById(alterProductSoldDTO.id())) {
            throw new ValidacaoExcpetion("Product sold with ID " + alterProductSoldDTO.id() + " does not exist.");
        }

        var productsSold = productsSoldRepository.findById(alterProductSoldDTO.id())
                .orElseThrow();
        var drinks = drinksRepository.findById(alterProductSoldDTO.drinksId())
                .orElseThrow();
        var foods = foodsRepository.findById(alterProductSoldDTO.foodsId())
                .orElseThrow();
        var sales = salesRepository.findById(alterProductSoldDTO.salesId())
                .orElseThrow();

        productsSold.update(alterProductSoldDTO, foods.getId(), drinks.getId(), sales.getId());

        return productsSoldRepository.save(productsSold);
    }

    public void deleteProductSold(String id) {
        if (!productsSoldRepository.existsById(id)) {
            throw new ValidacaoExcpetion("Product sold with ID " + id + " does not exist.");
        }
        productsSoldRepository.deleteById(id);
    }
}
