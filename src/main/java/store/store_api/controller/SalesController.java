package store.store_api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import store.store_api.dto.sales.AlterSalesDTO;
import store.store_api.dto.sales.ListSalesDTO;
import store.store_api.dto.sales.ResponseSaleDTO;
import store.store_api.dto.sales.SalesDTO;
import store.store_api.service.SalesService;

import java.util.List;

@RestController
@RequestMapping("/sales")
@AllArgsConstructor
@Validated
public class SalesController {

    private final SalesService salesService;

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
        return salesService.salesRegister(salesDTO);
    }

    @PutMapping
    public AlterSalesDTO alterSales(@RequestBody @Valid AlterSalesDTO alterSalesDTO) {
        return salesService.alterSales(alterSalesDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSales(@PathVariable String id) {
        salesService.deleteSales(id);;
    }
}
