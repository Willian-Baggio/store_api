package store.store_api.validations.drinks;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import store.store_api.dto.drinks.AlterDrinksDTO;
import store.store_api.repository.DrinksRepository;

@Component
public class DrinkQuantityValidation implements ValidationDrink{
    @Autowired
    private DrinksRepository drinksRepository;

    public void drinkValidation(AlterDrinksDTO alterDrinksDTO) throws ValidationException {
        if (alterDrinksDTO.quantity() == null) {
            throw new ValidationException("The quantity can't be null");
        }
    }
}
