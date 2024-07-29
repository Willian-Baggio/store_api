package store.store_api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import store.store_api.dto.foods.AlterFoodsDTO;
import store.store_api.dto.foods.FoodsDTO;
import store.store_api.dto.foods.ListFoodsDTO;
import store.store_api.dto.foods.ResponseFoodsDTO;
import store.store_api.service.FoodService;

import java.util.List;

@RestController
@RequestMapping("foods")
public class FoodsController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/{id}")
    public ListFoodsDTO listFoods(@PathVariable Long id) {
        return foodService.listFood(id);
    }

    @GetMapping
    public List<ListFoodsDTO> listAllFoods() {
        return foodService.listAllFoods();
    }

    @PostMapping
    public ResponseFoodsDTO foodsRegister(@RequestBody @Valid FoodsDTO foodsDTO) {
        var dto = foodService.createFood(foodsDTO);
        return new ResponseFoodsDTO(dto.getId() ,dto.getFoodName(),
                dto.getQuantity(), dto.getPrice(), dto.getDescription());
    }

    @PutMapping
    public AlterFoodsDTO alterFood(@RequestBody @Valid AlterFoodsDTO alterFoodsDTO) {
            var dto = foodService.alterFood(alterFoodsDTO);
            return new AlterFoodsDTO(dto.getId(), dto.getFoodName(), dto.getQuantity(),
                    dto.getPrice(), dto.getDescription());
    }

    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
    }
}
