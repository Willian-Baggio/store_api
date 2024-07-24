package store.store_api.service;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.store_api.dto.drinks.AlterDrinksDTO;
import store.store_api.dto.drinks.DrinksDTO;
import store.store_api.model.Drinks;
import store.store_api.repository.DrinksRepository;
import store.store_api.validations.drinks.ValidationDrink;

import java.util.List;

@Service
public class DrinkService {

    @Autowired
    private DrinksRepository drinksRepository;

    @Autowired
    private List<ValidationDrink> validationDrink;

    public Drinks createDrinks(DrinksDTO drinksDTO) {

        var drinks = new Drinks(drinksDTO.drinkName(), drinksDTO.quantity(),
                drinksDTO.price(), drinksDTO.description());
        drinksRepository.save(drinks);
        return new Drinks(drinks);
    }

    public AlterDrinksDTO alterDrink(AlterDrinksDTO alterDrinksDTO){
        if (!drinksRepository.existsById(alterDrinksDTO.id())) {
            throw new ValidationException("Drink with ID " + alterDrinksDTO.id() + " does not exist.");
        }
        validationDrink.forEach(v -> v.drinkValidation(alterDrinksDTO));

        var drinks = new Drinks(alterDrinksDTO);
        drinksRepository.save(drinks);
        return new AlterDrinksDTO(drinks);
    }

    public void removeDrink(Long id){
        if (!drinksRepository.existsById(id)) {
            throw new ValidationException("Drink with ID " + id + " does not exist.");
        }
        drinksRepository.deleteById(id);
    }

}
