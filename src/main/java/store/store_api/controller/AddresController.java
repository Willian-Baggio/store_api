package store.store_api.controller;

import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import store.store_api.dto.addres.AddresDataDTO;
import store.store_api.repository.AddresRepository;
import store.store_api.service.AddresService;

@RestController
@RequestMapping("addres")
public class AddresController {

    @Autowired
    private AddresService addresService;

    @Autowired
    private AddresRepository addresRepository;

    @PostMapping
    public ResponseEntity addresRegister(@RequestBody @Valid AddresDataDTO data, UriComponentsBuilder uriBuilder) throws BadRequestException {
        try {
            var dto = addresService.addresRegister(data);
            var uri = uriBuilder.path("/addres/{id}").buildAndExpand(dto.getId()).toUri();

            return ResponseEntity.created(uri).body(dto);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao cadastrar o endereço ", e);
        }
    }
}
