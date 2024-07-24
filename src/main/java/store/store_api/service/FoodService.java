package store.store_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.store_api.dto.foods.AlterFoodsDTO;
import store.store_api.dto.foods.FoodsDTO;
import store.store_api.exception.ValidacaoExcpetion;
import store.store_api.model.Foods;
import store.store_api.repository.FoodsRepository;

@Service
public class FoodService {

    @Autowired
    private FoodsRepository foodsRepository;

    public Foods createFood(FoodsDTO foodsDTO) {
        var foods = new Foods(foodsDTO.foodName(), foodsDTO.quantity(), foodsDTO.price(),
                foodsDTO.description());
        foodsRepository.save(foods);
        return new Foods(foods);
    }

    public AlterFoodsDTO alterFood(AlterFoodsDTO alterFoodsDTO) {
        if (!foodsRepository.existsById(alterFoodsDTO.id())) {
            throw new ValidacaoExcpetion("Food with ID " + alterFoodsDTO.id() + " does not exist.");
        }
        var foods = new Foods(alterFoodsDTO);
        foodsRepository.save(foods);
        return new AlterFoodsDTO(foods);
    }

    public void deleteFood(Long id) {
        if (!foodsRepository.existsById(id)) {
            throw new ValidacaoExcpetion("Food with ID " + id + " does not exist.");
        }
        foodsRepository.deleteById(id);
    }

}
