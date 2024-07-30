package store.store_api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import store.store_api.dto.addres.AddresDataDTO;
import store.store_api.dto.addres.ListAddresDTO;
import store.store_api.dto.addres.ResponseAddresDTO;
import store.store_api.service.AddresService;

import java.util.List;

@RestController
@RequestMapping("addres")
public class AddresController {

    @Autowired
    private AddresService addresService;

    @GetMapping("/{id}")
    public ListAddresDTO listAddresDTO(@PathVariable String id) {
        return  addresService.listAddres(id);
    }

    @GetMapping
    public List<ListAddresDTO> listAllAddres() {
        return addresService.listAllAddres();
    }

    @PostMapping
    public ResponseAddresDTO addresRegister(@RequestBody @Valid AddresDataDTO data) {
        var dto = addresService.addresRegister(data);
        return new ResponseAddresDTO(dto.getStreet(), dto.getNeighborhood(),
                dto.getZipCode(), dto.getNumber(), dto.getComplement(),
                dto.getCity(), dto.getUf());
    }

    @DeleteMapping("/{id}")
    public void deleteAddres(@PathVariable String id) {
        addresService.deleteAddres(id);
    }
}
