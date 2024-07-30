package store.store_api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import store.store_api.dto.sales.AlterSalesDTO;
import store.store_api.dto.sales.ListSalesDTO;
import store.store_api.dto.sales.ResponseSaleDTO;
import store.store_api.dto.sales.SalesDTO;
import store.store_api.service.SalesService;

import java.util.List;

@RestController
@RequestMapping("sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @GetMapping("/{id}")
    public ListSalesDTO listSales(@PathVariable String id) {
        return salesService.listSale(id);
    }

    @GetMapping
    public List<ListSalesDTO> listAllSales() {
        return salesService.listAllSales();
    }

    @PostMapping
    public ResponseSaleDTO salesRegister(@RequestBody @Valid SalesDTO salesDTO) {
        var dto = salesService.createSales(salesDTO);
        return new ResponseSaleDTO(dto.getId(), dto.getStores(), dto.getUsers(),
           dto.getSaleDate(), dto.getQuantitySold(), dto.getTotalPrice(),
           dto.getPaymentMethood());
    }

    @PutMapping
    public AlterSalesDTO alterSales(@RequestBody @Valid AlterSalesDTO alterSalesDTO) {
        var dto = salesService.alterSales(alterSalesDTO);
        return new AlterSalesDTO(dto.getId(), dto.getStores(), dto.getUsers(),
                dto.getQuantitySold(), dto.getTotalPrice(), dto.getPaymentMethood());
    }

    @DeleteMapping("/{id}")
    public void deleteSales(@PathVariable String id) {
        salesService.deleteSales(id);;
    }
}
