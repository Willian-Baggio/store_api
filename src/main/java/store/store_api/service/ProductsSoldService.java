package store.store_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.store_api.dto.productsSold.AlterProductSoldDTO;
import store.store_api.dto.productsSold.ProductSoldDTO;
import store.store_api.exception.ValidacaoExcpetion;
import store.store_api.model.ProductsSold;
import store.store_api.repository.ProductsSoldRepository;

@Service
public class ProductsSoldService {

    @Autowired
    private ProductsSoldRepository productsSoldRepository;

    public ProductsSold createProductSold(ProductSoldDTO productSoldDTO) {
        var productsSold = new ProductsSold(productSoldDTO);
        productsSoldRepository.save(productsSold);
        return new ProductsSold(productSoldDTO);
    }

    public AlterProductSoldDTO alterProductSold(AlterProductSoldDTO alterProductSoldDTO) {
        if (!productsSoldRepository.existsById(alterProductSoldDTO.id())) {
            throw new ValidacaoExcpetion("Product sold with ID " + alterProductSoldDTO.id() + " does not exist.");
        }
        var productsSold = new ProductsSold();
        productsSoldRepository.save(productsSold);
        return new AlterProductSoldDTO(productsSold);
    }

    public void deleteProductSold(Long id) {
        if (!productsSoldRepository.existsById(id)) {
            throw new ValidacaoExcpetion("Product sold with ID " + id + " does not exist.");
        }
        productsSoldRepository.deleteById(id);
    }

}
