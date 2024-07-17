package store.store_api.validations.drinks;

import store.store_api.dto.drinks.AlterDrinksDTO;

public interface ValidationDrink {
    void drinkValidation(AlterDrinksDTO alterDrinksDTO);
}
