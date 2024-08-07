package store.store_api.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import store.store_api.dto.sales.AlterSalesDTO;
import store.store_api.dto.sales.ListSalesDTO;
import store.store_api.dto.sales.ResponseSaleDTO;
import store.store_api.dto.sales.SalesDTO;
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

    public List<ListSalesDTO> listAllSales() {
        List<Sales> salesList = salesRepository.findAll();
        return salesList.stream()
                .map(ListSalesDTO::new)
                .collect(Collectors.toList());
    }

    public ListSalesDTO listSale(String id) {
        var sales = findSalesById(id);
        return new ListSalesDTO(sales);
    }

    public ResponseSaleDTO salesRegister(SalesDTO salesDTO) {
        var stores = storeService.findStoresById(salesDTO.storeId());
        var users = usersService.findUserById(salesDTO.userId());

        var sales = new Sales(stores.getId(), users.getId(),
                salesDTO.quantitySold(), salesDTO.totalPrice(), salesDTO.paymentMethood());
        var saveSales = salesRepository.save(sales);
        return new ResponseSaleDTO(saveSales.getId(), saveSales.getStores(), saveSales.getUsers(),
                saveSales.getSaleDate(), saveSales.getQuantitySold(), saveSales.getTotalPrice(),
                saveSales.getPaymentMethood());
    }

    public AlterSalesDTO alterSales(AlterSalesDTO alterSalesDTO) {
        var sales = findSalesById(alterSalesDTO.id());
        sales.update(alterSalesDTO);
        return new AlterSalesDTO(sales.getId(), sales.getStores(), sales.getUsers(), sales.getQuantitySold(),
                sales.getTotalPrice(), sales.getPaymentMethood());
    }

    public void deleteSales(String id) {
        findSalesById(id);
        salesRepository.deleteById(id);
    }

    public Sales findSalesById(String id) {
        return salesRepository.findById(id)
                .orElseThrow(() -> new jakarta.validation.ValidationException("Sales with ID " +
                        id + " does not exist."));
    }
}
