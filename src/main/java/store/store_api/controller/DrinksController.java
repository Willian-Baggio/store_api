package store.store_api.controller;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.store_api.dto.drinks.AlterDrinksDTO;
import store.store_api.dto.drinks.DrinksDTO;
import store.store_api.service.DrinkService;

@RestController
@RequestMapping("drinks")
public class DrinksController {

    @Autowired
    private DrinkService drinkService;

    @PostMapping
    public ResponseEntity drinksRegister(@RequestBody @Valid DrinksDTO drinksDTO) {
        try {
            return ResponseEntity.ok("Drink create!");
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity alterDrink(@PathVariable Long id, @RequestBody @Valid AlterDrinksDTO alterDrinksDTO) {
        try {
            drinkService.alterDrink(id, alterDrinksDTO);
            return ResponseEntity.ok("The drinks has been alter");
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
