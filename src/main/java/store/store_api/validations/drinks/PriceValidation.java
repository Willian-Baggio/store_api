package store.store_api.validations.drinks;

import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;
import store.store_api.dto.drinks.AlterDrinksDTO;

@Component
public class PriceValidation implements ValidationDrink{

    public void drinkValidation(AlterDrinksDTO alterDrinksDTO) throws ValidationException {
        if (alterDrinksDTO.price() == null) {
            throw new ValidationException("The price can't be null");
        }
    }
}
