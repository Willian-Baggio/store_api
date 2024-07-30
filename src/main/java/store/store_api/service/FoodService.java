package store.store_api.service;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.store_api.dto.foods.AlterFoodsDTO;
import store.store_api.dto.foods.FoodsDTO;
import store.store_api.dto.foods.ListFoodsDTO;
import store.store_api.exception.ValidacaoExcpetion;
import store.store_api.model.Foods;
import store.store_api.repository.FoodsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodService {

    @Autowired
    private FoodsRepository foodsRepository;

    public List<ListFoodsDTO> listAllFoods() {
        List<Foods> foodsList = foodsRepository.findAll();
        return foodsList.stream()
                .map(ListFoodsDTO::new)
                .collect(Collectors.toList());
    }

    public ListFoodsDTO listFood(String id) {
        var foods = foodsRepository.findById(id)
                .orElseThrow(() -> new ValidationException("Addres with ID " + id + " does not exist."));
        return new ListFoodsDTO(foods);
    }

    public Foods createFood(FoodsDTO foodsDTO) {
        var foods = new Foods(foodsDTO.foodName(), foodsDTO.quantity(), foodsDTO.price(),
                foodsDTO.description());
        return foodsRepository.save(foods);
    }

    public Foods alterFood(AlterFoodsDTO alterFoodsDTO) {
        var foods = foodsRepository.findById(alterFoodsDTO.id())
                .orElseThrow(() -> new ValidationException("Addres with ID " + alterFoodsDTO.id() + " does not exist."));;
        foods.update(alterFoodsDTO);
        return foodsRepository.save(foods);
    }

    public void deleteFood(String id) {
        if (!foodsRepository.existsById(id)) {
            throw new ValidacaoExcpetion("Food with ID " + id + " does not exist.");
        }
        foodsRepository.deleteById(id);
    }
}
