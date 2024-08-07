package store.store_api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import store.store_api.dto.address.AddressDataDTO;
import store.store_api.dto.address.ListAddressDTO;
import store.store_api.dto.address.ResponseAddressDTO;
import store.store_api.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/address")
@AllArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/{id}")
    public ListAddressDTO listAddressDTO(@PathVariable String id) {
        return  addressService.listAddress(id);
    }

    @GetMapping
    public List<ListAddressDTO> listAllAddress() {
        return addressService.listAllAddress();
    }

    @PostMapping
    public ResponseAddressDTO addressRegister(@RequestBody @Valid AddressDataDTO data) {
        return addressService.addressRegister(data);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable String id) {
        addressService.deleteAddress(id);
    }
}
