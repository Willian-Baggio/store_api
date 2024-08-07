package store.store_api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import store.store_api.dto.drinks.AlterDrinksDTO;
import store.store_api.dto.drinks.DrinksDTO;
import store.store_api.dto.drinks.ListDrinksDTO;
import store.store_api.dto.drinks.ResponseDrinksDTO;
import store.store_api.service.DrinksService;

import java.util.List;

@RestController
@RequestMapping("/drinks")
@AllArgsConstructor
public class DrinksController {

    private final DrinksService drinkService;

    @GetMapping("/{id}")
    public ListDrinksDTO listDrinks(@PathVariable String id) {
        return drinkService.listDrink(id);
    }

    @GetMapping
    public List<ListDrinksDTO> listAllDrinks() {
        return drinkService.listAllDrinks();
    }

    @PostMapping
    public ResponseDrinksDTO drinksRegister(@RequestBody @Valid DrinksDTO drinksDTO) {
        return drinkService.drinksRegister(drinksDTO);
    }

    @PutMapping
    public AlterDrinksDTO alterDrink(@RequestBody @Valid AlterDrinksDTO alterDrinksDTO) {
        return drinkService.alterDrink(alterDrinksDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDrink(@PathVariable String id) {
        drinkService.deleteDrink(id);
    }
}
