package store.store_api.service;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.store_api.dto.drinks.AlterDrinksDTO;
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

    public void alterDrink(Long id, AlterDrinksDTO alterDrinksDTO){
        if (!drinksRepository.existsById(alterDrinksDTO.id())) {
            throw new ValidationException("Drink with ID " + alterDrinksDTO.id() + " does not exist.");
        }
        validationDrink.forEach(v -> v.drinkValidation(alterDrinksDTO));

        Drinks drinks = new Drinks();
        drinksRepository.save(drinks);
    }

    public void removeDrink(Long id){
        if (!drinksRepository.existsById(id)) {
            throw new ValidationException("Drink with ID " + id + " does not exist.");
        }
        drinksRepository.deleteById(id);
    }
}
