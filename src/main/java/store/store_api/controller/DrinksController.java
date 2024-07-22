package store.store_api.controller;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import store.store_api.dto.drinks.AlterDrinksDTO;
import store.store_api.dto.drinks.DrinksDTO;
import store.store_api.service.DrinkService;

@RestController
@RequestMapping("drinks")
public class DrinksController {

    @Autowired
    private DrinkService drinkService;

    @PostMapping
    public ResponseEntity drinksRegister(@RequestBody @Valid DrinksDTO drinksDTO, UriComponentsBuilder uriBuilder) {
        try {
            var dto = drinkService.createDrinks(drinksDTO);
            var uri = uriBuilder.path("/drinks/{id}").buildAndExpand(dto.getId()).toUri();

            return ResponseEntity.created(uri).body(dto);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity alterDrink(@RequestBody @Valid AlterDrinksDTO alterDrinksDTO) {
        try {
            var dto = drinkService.alterDrink(alterDrinksDTO);
            return ResponseEntity.ok(dto);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDrink(@PathVariable Long id) {
        try {
            drinkService.removeDrink(id);
            return ResponseEntity.noContent().build();
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
