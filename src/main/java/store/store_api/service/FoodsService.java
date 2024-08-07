package store.store_api.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import store.store_api.dto.foods.AlterFoodsDTO;
import store.store_api.dto.foods.FoodsDTO;
import store.store_api.dto.foods.ListFoodsDTO;
import store.store_api.dto.foods.ResponseFoodsDTO;
import store.store_api.exception.ValidationException;
import store.store_api.mapper.FoodsMapper;
import store.store_api.model.Foods;
import store.store_api.repository.FoodsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FoodsService {

    private final FoodsRepository foodsRepository;
    private final FoodsMapper foodsMapper = FoodsMapper.INSTANCE;

    public List<ListFoodsDTO> listAllFoods() {
        List<Foods> foodsList = foodsRepository.findAll();
        return foodsList.stream()
                .map(foodsMapper::toListFoodsDTO)
                .collect(Collectors.toList());
    }

    public ListFoodsDTO listFood(String id) {
        var foods = findFoodsById(id);
        return foodsMapper.toListFoodsDTO(foods);
    }

    public ResponseFoodsDTO foodsRegister(FoodsDTO foodsDTO) {
        var foods = foodsMapper.toFoods(foodsDTO);
        var saveFoods = foodsRepository.save(foods);
        return foodsMapper.toResponseFoodsDTO(saveFoods);
    }

    public AlterFoodsDTO alterFood(AlterFoodsDTO alterFoodsDTO) {
        var foods = findFoodsById(alterFoodsDTO.id());
        foods.update(alterFoodsDTO);
        return foodsMapper.toAlterFoodsDTO(foods);
    }

    public void deleteFood(String id) {
        findFoodsById(id);
        foodsRepository.deleteById(id);
    }

    public Foods findFoodsById(String id) {
        return foodsRepository.findById(id)
                .orElseThrow(() -> new jakarta.validation.ValidationException("Food with ID "
                        + id + " does not exist."));
    }
}
