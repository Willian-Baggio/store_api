package store.store_api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import store.store_api.dto.drinks.AlterDrinksDTO;
import store.store_api.dto.drinks.DrinksDTO;
import store.store_api.dto.drinks.ListDrinksDTO;
import store.store_api.dto.drinks.ResponseDrinksDTO;
import store.store_api.service.DrinkService;

import java.util.List;

@RestController
@RequestMapping("drinks")
public class DrinksController {

    @Autowired
    private DrinkService drinkService;

    @GetMapping("/{id}")
    public ListDrinksDTO listDrinks(@PathVariable Long id) {
        return drinkService.listDrink(id);
    }

    @GetMapping
    public List<ListDrinksDTO> listAllDrinks() {
        return drinkService.listAllDrinks();
    }

    @PostMapping
    public ResponseDrinksDTO drinksRegister(@RequestBody @Valid DrinksDTO drinksDTO) {
        var dto = drinkService.createDrinks(drinksDTO);

        return new ResponseDrinksDTO(dto.getId(), dto.getDrinkName(), dto.getQuantity(),
                dto.getPrice(), dto.getDescription());
    }

    @PutMapping
    public AlterDrinksDTO alterDrink(@RequestBody @Valid AlterDrinksDTO alterDrinksDTO) {
        var dto = drinkService.alterDrink(alterDrinksDTO);
        return new AlterDrinksDTO(dto.getId(), dto.getDrinkName(), dto.getQuantity(),
                dto.getPrice(), dto.getDescription());
    }

    @DeleteMapping("/{id}")
    public void deleteDrink(@PathVariable Long id) {
        drinkService.removeDrink(id);
    }
}
