package store.store_api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import store.store_api.dto.drinks.AlterDrinksDTO;
import store.store_api.dto.drinks.DrinksDTO;
import store.store_api.dto.drinks.ListDrinksDTO;
import store.store_api.dto.drinks.ResponseDrinksDTO;
import store.store_api.exception.CustomValidationException;
import store.store_api.model.Drinks;
import store.store_api.repository.DrinksRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DrinksService {

    private final DrinksRepository drinksRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<ListDrinksDTO> listAllDrinks() {
        List<Drinks> drinksList = drinksRepository.findAll();

        return drinksList.stream()
                .map(drink -> objectMapper.convertValue(drink, ListDrinksDTO.class))
                .collect(Collectors.toList());
    }

    public ListDrinksDTO listDrink(String id){
        var drink = findDrinkById(id);
        return objectMapper.convertValue(drink, ListDrinksDTO.class);
    }

    public ResponseDrinksDTO drinksRegister(DrinksDTO drinksDTO) {
        try {
            var drinks = objectMapper.convertValue(drinksDTO, Drinks.class);
            var savedDrinks = drinksRepository.save(drinks);
            return objectMapper.convertValue(savedDrinks, ResponseDrinksDTO.class);
        } catch (CustomValidationException e) {
            throw new CustomValidationException(e.getMessage());
        }
    }

    public AlterDrinksDTO alterDrink(AlterDrinksDTO alterDrinksDTO){
        try {
            var drink = findDrinkById(alterDrinksDTO.id());
            drink.update(alterDrinksDTO);
            return objectMapper.convertValue(drinksRepository.save(drink), AlterDrinksDTO.class);
        } catch (CustomValidationException e) {
            throw new CustomValidationException(e.getMessage());
        }
    }

    public void deleteDrink(String id){
        findDrinkById(id);
        drinksRepository.deleteById(id);
    }

    public Drinks findDrinkById(String id) {
        return drinksRepository.findById(id)
                .orElseThrow(() -> new CustomValidationException("Drink with ID " +
                        id + " does not exist."));
    }
}
