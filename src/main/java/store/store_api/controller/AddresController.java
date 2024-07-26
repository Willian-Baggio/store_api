package store.store_api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import store.store_api.dto.addres.AddresDataDTO;
import store.store_api.dto.addres.AlterAddresDTO;
import store.store_api.dto.addres.ResponseAddresDTO;
import store.store_api.service.AddresService;

@RestController
@RequestMapping("addres")
public class AddresController {

    @Autowired
    private AddresService addresService;

    @PostMapping
    public ResponseAddresDTO addresRegister(@RequestBody @Valid AddresDataDTO data) {
        var dto = addresService.addresRegister(data);
        return new ResponseAddresDTO(dto.getStreet(), dto.getNeighborhood(),
                dto.getZipCode(), dto.getNumber(), dto.getComplement(),
                dto.getCity(), dto.getUf());
    }

    @PutMapping
    public AlterAddresDTO alterAddres(@RequestBody @Valid AlterAddresDTO alterAddresDTO) {
        var dto = addresService.alterAddres(alterAddresDTO);
        return new AlterAddresDTO(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteAddres(@PathVariable Long id) {
        addresService.deleteAddres(id);
    }
}
