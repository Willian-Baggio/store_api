package store.store_api.service;

import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import store.store_api.dto.drinks.AlterDrinksDTO;
import store.store_api.dto.drinks.DrinksDTO;
import store.store_api.dto.drinks.ListDrinksDTO;
import store.store_api.dto.drinks.ResponseDrinksDTO;
import store.store_api.mapper.DrinksMapper;
import store.store_api.model.Drinks;
import store.store_api.repository.DrinksRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DrinksService {

    private final DrinksRepository drinksRepository;
    private final DrinksMapper drinksMapper = DrinksMapper.INSTANCE;

    public List<ListDrinksDTO> listAllDrinks() {
        List<Drinks> drinksList = drinksRepository.findAll();
        return drinksList.stream()
                .map(drinksMapper::toListDrinksDTO)
                .collect(Collectors.toList());
    }

    public ListDrinksDTO listDrink(String id) {
        var drinks = findDrinkById(id);
        return drinksMapper.toListDrinksDTO(drinks);
    }

    public ResponseDrinksDTO drinksRegister(DrinksDTO drinksDTO) {
        var drinks = drinksMapper.toDrinks(drinksDTO);
        var saveDrinks = drinksRepository.save(drinks);
        return drinksMapper.toResponseDrinksDTO(saveDrinks);
    }

    public AlterDrinksDTO alterDrink(AlterDrinksDTO alterDrinksDTO){
        var drink = findDrinkById(alterDrinksDTO.id());
        drink.update(alterDrinksDTO);
        return drinksMapper.toAlterDrinksDTO(drink);
    }

    public void deleteDrink(String id){
        findDrinkById(id);
        drinksRepository.deleteById(id);
    }

    public Drinks findDrinkById(String id) {
        return drinksRepository.findById(id)
                .orElseThrow(() -> new ValidationException("Drink with ID " +
                        id + " does not exist."));
    }
}
