package store.store_api.controller;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import store.store_api.dto.addres.AddresDataDTO;
import store.store_api.dto.addres.AlterAddresDTO;
import store.store_api.repository.AddresRepository;
import store.store_api.service.AddresService;

@RestController
@RequestMapping("addres")
public class AddresController {

    @Autowired
    private AddresService addresService;

    @PostMapping
    public ResponseEntity addresRegister(@RequestBody @Valid AddresDataDTO data, UriComponentsBuilder uriBuilder) throws BadRequestException {
        try {
            var dto = addresService.addresRegister(data);
            var uri = uriBuilder.path("/addres/{id}").buildAndExpand(dto.getId()).toUri();

            return ResponseEntity.created(uri).body(dto);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity alterAddres(@RequestBody @Valid AlterAddresDTO alterAddresDTO) {
        try {
            var dto = addresService.alterAddres(alterAddresDTO);
            return ResponseEntity.ok(dto);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAddres(@PathVariable Long id) {
        try {
            addresService.deleteAddres(id);
            return ResponseEntity.noContent().build();
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
