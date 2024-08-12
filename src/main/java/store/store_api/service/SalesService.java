package store.store_api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import store.store_api.dto.sales.AlterSalesDTO;
import store.store_api.dto.sales.ListSalesDTO;
import store.store_api.dto.sales.ResponseSaleDTO;
import store.store_api.dto.sales.SalesDTO;
import store.store_api.exception.CustomValidationException;
import store.store_api.model.Sales;
import store.store_api.repository.SalesRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SalesService {

    private final SalesRepository salesRepository;
    private final StoreService storeService;
    private final UsersService usersService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<ListSalesDTO> listAllSales() {
        List<Sales> salesList = salesRepository.findAll();
        return salesList.stream()
                .map(sales -> objectMapper.convertValue(sales, ListSalesDTO.class))
                .collect(Collectors.toList());
    }

    public ListSalesDTO listSale(String id) {
        var sales = findSalesById(id);
        return objectMapper.convertValue(sales, ListSalesDTO.class);
    }

    public ResponseSaleDTO salesRegister(SalesDTO salesDTO) {
        try {
            var stores = storeService.findStoresById(salesDTO.storeId());
            var usersDTO = salesDTO.cpf().cpf();

            var sales = new Sales(stores.getId(), usersDTO,
                    salesDTO.quantitySold(), salesDTO.totalPrice(), salesDTO.paymentMethod());
            var saveSales = salesRepository.save(sales);
            return objectMapper.convertValue(saveSales, ResponseSaleDTO.class);
        } catch (CustomValidationException e) {
            throw new CustomValidationException(e.getMessage());
        }
    }

    public AlterSalesDTO alterSales(AlterSalesDTO alterSalesDTO) {
        try {
            var sales = findSalesById(alterSalesDTO.id());
            sales.update(alterSalesDTO);
            var saveSales = salesRepository.save(sales);
            return objectMapper.convertValue(saveSales, AlterSalesDTO.class);
        } catch (CustomValidationException e) {
            throw new CustomValidationException(e.getMessage());
        }
    }

    public void deleteSales(String id) {
        findSalesById(id);
        salesRepository.deleteById(id);
    }

    public Sales findSalesById(String id) {
        return salesRepository.findById(id)
                .orElseThrow(() -> new CustomValidationException("Sales with ID " +
                        id + " does not exist."));
    }
}
