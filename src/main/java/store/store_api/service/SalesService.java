package store.store_api.service;

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

    public Sales createSales(SalesDTO salesDTO) {
        var stores = storesRepository.findById(salesDTO.storeId()).get();
        var users = usersRepository.findById(salesDTO.userId()).get();

        var sales = new Sales(stores, users,
                salesDTO.quantitySold(), salesDTO.totalPrice(), salesDTO.paymentMethood());

        return salesRepository.save(sales);
    }

    public Sales alterSales(AlterSalesDTO alterSalesDTO) {
        if (!salesRepository.existsById(alterSalesDTO.id())) {
            throw new ValidacaoExcpetion("Sales with ID " + alterSalesDTO.id() + " does not exist.");
        }
        var sales = salesRepository.getReferenceById(alterSalesDTO.id());
        sales.update(alterSalesDTO);
        return salesRepository.save(sales);
    }

    public void deleteSales(Long id) {
        if (!salesRepository.existsById(id)) {
            throw new ValidacaoExcpetion("Sales with ID " + id + " does not exist.");
        }
        salesRepository.deleteById(id);
    }

    public ListSalesDTO listSale(Long id) {
        if (!salesRepository.existsById(id)) {
            throw new ValidacaoExcpetion("Sales with ID " + id + " does not exist.");
        }

        var sales = salesRepository.getReferenceById(id);
        return new ListSalesDTO(sales);
    }

}
