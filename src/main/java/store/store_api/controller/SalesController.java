package store.store_api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import store.store_api.dto.sales.AlterSalesDTO;
import store.store_api.dto.sales.ResponseSaleDTO;
import store.store_api.dto.sales.SalesDTO;
import store.store_api.service.SalesService;

@RestController
@RequestMapping("sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @PostMapping
    public ResponseSaleDTO salesRegister(@RequestBody @Valid SalesDTO salesDTO) {
        var dto = salesService.createSales(salesDTO);
        return new ResponseSaleDTO(dto.getId(), dto.getStores().getId(), dto.getUsers().getId(),
           dto.getSaleDate(), dto.getQuantitySold(), dto.getTotalPrice(),
           dto.getPaymentMethood());
    }

    @PutMapping
    public AlterSalesDTO alterSales(@RequestBody @Valid AlterSalesDTO alterSalesDTO) {
        var dto = salesService.alterSales(alterSalesDTO);
        return new AlterSalesDTO(dto.getId(), dto.getStores().getId(), dto.getUsers().getId(),
                dto.getQuantitySold(), dto.getTotalPrice(), dto.getPaymentMethood());
    }

    @DeleteMapping("/{id}")
    public void deleteSales(@PathVariable Long id) {
        salesService.deleteSales(id);;
    }
}
