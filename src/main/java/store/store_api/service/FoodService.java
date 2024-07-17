package store.store_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.store_api.dto.foods.AlterFoodsDTO;
import store.store_api.exception.ValidacaoExcpetion;
import store.store_api.model.Foods;
import store.store_api.repository.FoodsRepository;

@Service
public class FoodService {

    @Autowired
    private FoodsRepository foodsRepository;

    public void alterFood(AlterFoodsDTO alterFoodsDTO) {
        if (!foodsRepository.existsById(alterFoodsDTO.id())) {
            throw new ValidacaoExcpetion("User with ID " + alterFoodsDTO.id() + " does not exist.");
        }
        Foods foods = new Foods();
        foodsRepository.save(foods);
    }

    public void deleteFood(Long id) {
        if (!foodsRepository.existsById(id)) {
            throw new ValidacaoExcpetion("User with ID " + id + " does not exist.");
        }
        foodsRepository.deleteById(id);
    }
}
