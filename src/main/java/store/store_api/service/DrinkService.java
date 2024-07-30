package store.store_api.service;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.store_api.dto.drinks.AlterDrinksDTO;
import store.store_api.dto.drinks.DrinksDTO;
import store.store_api.dto.drinks.ListDrinksDTO;
import store.store_api.model.Drinks;
import store.store_api.repository.DrinksRepository;
import store.store_api.validations.drinks.ValidationDrink;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DrinkService {

    @Autowired
    private DrinksRepository drinksRepository;

    @Autowired
    private List<ValidationDrink> validationDrink;

    public List<ListDrinksDTO> listAllDrinks() {
        List<Drinks> drinksList = drinksRepository.findAll();
        return drinksList.stream()
                .map(ListDrinksDTO::new)
                .collect(Collectors.toList());
    }

    public ListDrinksDTO listDrink(String id) {
        var drinks = drinksRepository.findById(id)
                .orElseThrow(() -> new ValidationException("Addres with ID " + id + " does not exist."));
        return new ListDrinksDTO(drinks);
    }

    public Drinks createDrinks(DrinksDTO drinksDTO) {
        var drinks = new Drinks(drinksDTO.drinkName(), drinksDTO.quantity(),
                drinksDTO.price(), drinksDTO.description());
        return drinksRepository.save(drinks);
    }

    public Drinks alterDrink(AlterDrinksDTO alterDrinksDTO){
        if (!drinksRepository.existsById(alterDrinksDTO.id())) {
            throw new ValidationException("Drink with ID " + alterDrinksDTO.id() + " does not exist.");
        }

        var drink = drinksRepository.findById(alterDrinksDTO.id())
                .orElseThrow(() -> new ValidationException("Drink with ID " + alterDrinksDTO.id() + " does not exist."));
        drink.update(alterDrinksDTO);
        return drinksRepository.save(drink);
    }

    public void removeDrink(String id){
        if (!drinksRepository.existsById(id)) {
            throw new ValidationException("Drink with ID " + id + " does not exist.");
        }
        drinksRepository.deleteById(id);
    }

}
