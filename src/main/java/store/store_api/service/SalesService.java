package store.store_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.store_api.dto.sales.AlterSalesDTO;
import store.store_api.dto.sales.SalesDTO;
import store.store_api.exception.ValidacaoExcpetion;
import store.store_api.model.Sales;
import store.store_api.repository.SalesRepository;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

    public Sales createSales(SalesDTO salesDTO) {
        var sales = new Sales(salesDTO);
        salesRepository.save(sales);
        return new Sales(sales);
    }

    public AlterSalesDTO alterSales(AlterSalesDTO alterSalesDTO) {
        if (!salesRepository.existsById(alterSalesDTO.id())) {
            throw new ValidacaoExcpetion("Sales with ID " + alterSalesDTO.id() + " does not exist.");
        }
        var sales = new Sales(alterSalesDTO);
        salesRepository.save(sales);
        return new AlterSalesDTO(sales);
    }

    public void deleteSales(Long id) {
        if (!salesRepository.existsById(id)) {
            throw new ValidacaoExcpetion("Sales with ID " + id + " does not exist.");
        }
        salesRepository.deleteById(id);
    }
}
