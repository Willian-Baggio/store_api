package store.store_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.store_api.dto.productsSold.AlterProductSoldDTO;
import store.store_api.dto.productsSold.ProductSoldDTO;
import store.store_api.exception.ValidacaoExcpetion;
import store.store_api.model.ProductsSold;
import store.store_api.repository.ProductsSoldRepository;
import store.store_api.repository.SalesRepository;

@Service
public class ProductsSoldService {

    @Autowired
    private ProductsSoldRepository productsSoldRepository;

    @Autowired
    private SalesRepository salesRepository;

    public ProductsSold createProductSold(ProductSoldDTO productSoldDTO) {
        var productsSold = new ProductsSold(productSoldDTO.foods(), productSoldDTO.drinks(),
                productSoldDTO.sales());
        return productsSoldRepository.save(productsSold);
    }

    public ProductsSold alterProductSold(AlterProductSoldDTO alterProductSoldDTO) {
        if (!productsSoldRepository.existsById(alterProductSoldDTO.id())) {
            throw new ValidacaoExcpetion("Product sold with ID " + alterProductSoldDTO.id() + " does not exist.");
        }
        var sales = salesRepository.getReferenceById(alterProductSoldDTO.foods().getId());

        var products = new ProductsSold(alterProductSoldDTO.id(), alterProductSoldDTO.foods(),
                alterProductSoldDTO.drinks(), sales);
        products.update(alterProductSoldDTO);

        return productsSoldRepository.save(products);
    }

    public void deleteProductSold(Long id) {
        if (!productsSoldRepository.existsById(id)) {
            throw new ValidacaoExcpetion("Product sold with ID " + id + " does not exist.");
        }
        productsSoldRepository.deleteById(id);
    }

}
