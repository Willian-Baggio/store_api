package store.store_api.service;

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

    public Foods createFood(FoodsDTO foodsDTO) {
        var foods = new Foods(foodsDTO.foodName(), foodsDTO.quantity(), foodsDTO.price(),
                foodsDTO.description());
        return foodsRepository.save(foods);
    }

    public Foods alterFood(AlterFoodsDTO alterFoodsDTO) {
        if (!foodsRepository.existsById(alterFoodsDTO.id())) {
            throw new ValidacaoExcpetion("Food with ID " + alterFoodsDTO.id() + " does not exist.");
        }

        var foods = foodsRepository.getReferenceById(alterFoodsDTO.id());
        foods.update(alterFoodsDTO);
        return foodsRepository.save(foods);
    }

    public void deleteFood(Long id) {
        if (!foodsRepository.existsById(id)) {
            throw new ValidacaoExcpetion("Food with ID " + id + " does not exist.");
        }
        foodsRepository.deleteById(id);
    }

    public ListFoodsDTO listFood(Long id) {
        if (!foodsRepository.existsById(id)) {
            throw new ValidacaoExcpetion("Food with ID " + id + " does not exist.");
        }

        var foods = foodsRepository.getReferenceById(id);
        return new ListFoodsDTO(foods);
    }

}
