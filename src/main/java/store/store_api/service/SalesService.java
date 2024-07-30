package store.store_api.service;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.store_api.dto.sales.AlterSalesDTO;
import store.store_api.dto.sales.ListSalesDTO;
import store.store_api.dto.sales.SalesDTO;
import store.store_api.exception.ValidacaoExcpetion;
import store.store_api.model.Sales;
import store.store_api.repository.SalesRepository;
import store.store_api.repository.StoresRepository;
import store.store_api.repository.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private StoresRepository storesRepository;

    @Autowired
    private UsersRepository usersRepository;

    public List<ListSalesDTO> listAllSales() {
        List<Sales> salesList = salesRepository.findAll();
        return salesList.stream()
                .map(ListSalesDTO::new)
                .collect(Collectors.toList());
    }

    public ListSalesDTO listSale(String id) {
        var sales = salesRepository.findById(id)
                .orElseThrow(() -> new ValidationException("Addres with ID " + id + " does not exist."));
        return new ListSalesDTO(sales);
    }

    public Sales createSales(SalesDTO salesDTO) {
        var stores = storesRepository.findById(salesDTO.storeId())
                .orElseThrow();
        var users = usersRepository.findById(salesDTO.userId())
                .orElseThrow();

        var sales = new Sales(stores.getId(), users.getId(),
                salesDTO.quantitySold(), salesDTO.totalPrice(), salesDTO.paymentMethood());

        return salesRepository.save(sales);
    }

    public Sales alterSales(AlterSalesDTO alterSalesDTO) {
        var sales = salesRepository.findById(alterSalesDTO.id())
                .orElseThrow(() -> new ValidationException("Sale with ID " + alterSalesDTO.id() + " does not exist."));
        sales.update(alterSalesDTO);
        return salesRepository.save(sales);
    }

    public void deleteSales(String id) {
        if (!salesRepository.existsById(id)) {
            throw new ValidacaoExcpetion("Sales with ID " + id + " does not exist.");
        }
        salesRepository.deleteById(id);
    }


}
