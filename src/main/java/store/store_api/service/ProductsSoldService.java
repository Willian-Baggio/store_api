package store.store_api.service;

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

    public ListProductSoldDTO listProductSale(Long id) {
        var productsSold = productsSoldRepository.getReferenceById(id);
        return new ListProductSoldDTO(productsSold);
    }

    public ProductsSold createProductSold(ProductSoldDTO productSoldDTO) {
        var foods = foodsRepository.getReferenceById(productSoldDTO.foodsId());
        var drinks = drinksRepository.getReferenceById(productSoldDTO.drinksId());
        var sales = salesRepository.getReferenceById(productSoldDTO.salesId());

        var productsSold = new ProductsSold(foods, drinks, sales);
        return productsSoldRepository.save(productsSold);
    }

    public ProductsSold alterProductSold(AlterProductSoldDTO alterProductSoldDTO) {
        if (!productsSoldRepository.existsById(alterProductSoldDTO.id())) {
            throw new ValidacaoExcpetion("Product sold with ID " + alterProductSoldDTO.id() + " does not exist.");
        }

        var productsSold = productsSoldRepository.getReferenceById(alterProductSoldDTO.id());
        var drinks = drinksRepository.getReferenceById(alterProductSoldDTO.drinksId());
        var foods = foodsRepository.getReferenceById(alterProductSoldDTO.foodsId());
        var sales = salesRepository.getReferenceById(alterProductSoldDTO.salesId());

        productsSold.update(alterProductSoldDTO, foods, drinks, sales);

        return productsSoldRepository.save(productsSold);
    }

    public void deleteProductSold(Long id) {
        if (!productsSoldRepository.existsById(id)) {
            throw new ValidacaoExcpetion("Product sold with ID " + id + " does not exist.");
        }
        productsSoldRepository.deleteById(id);
    }

}
