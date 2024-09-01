package store.store_api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import store.store_api.dto.foods.AlterFoodsDTO;
import store.store_api.dto.foods.FoodsDTO;
import store.store_api.dto.foods.ListFoodsDTO;
import store.store_api.dto.foods.ResponseFoodsDTO;
import store.store_api.exception.CustomValidationException;
import store.store_api.model.Foods;
import store.store_api.repository.FoodsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FoodsService {

    private final FoodsRepository foodsRepository;
    private final ObjectMapper objectMapper;

    public List<ListFoodsDTO> listAllFoods() {
        List<Foods> foodsList = foodsRepository.findAll();
        return foodsList.stream()
                .map(foods -> objectMapper.convertValue(foods, ListFoodsDTO.class))
                .collect(Collectors.toList());
    }

    public ListFoodsDTO listFood(String id) {
        var foods = findFoodsById(id);
        return objectMapper.convertValue(foods, ListFoodsDTO.class);
    }

    public ResponseFoodsDTO foodsRegister(FoodsDTO foodsDTO) {
        try {
            var foods = objectMapper.convertValue(foodsDTO, Foods.class);
            var saveFoods = foodsRepository.save(foods);
            return objectMapper.convertValue(saveFoods, ResponseFoodsDTO.class);
        } catch (CustomValidationException e) {
            throw new CustomValidationException(e.getMessage());
        }
    }

    public AlterFoodsDTO alterFood(AlterFoodsDTO alterFoodsDTO) {
        try {
            var foods = findFoodsById(alterFoodsDTO.id());
            foods.update(alterFoodsDTO);
            var saveFoods = foodsRepository.save(foods);
            return objectMapper.convertValue(saveFoods, AlterFoodsDTO.class);
        } catch (CustomValidationException e) {
            throw new CustomValidationException(e.getMessage());
        }
    }

    public void deleteFood(String id) {
        findFoodsById(id);
        foodsRepository.deleteById(id);
    }

    public Foods findFoodsById(String id) {
        return foodsRepository.findById(id)
                .orElseThrow(() -> new CustomValidationException("Food with ID "
                        + id + " does not exist."));
    }
}
