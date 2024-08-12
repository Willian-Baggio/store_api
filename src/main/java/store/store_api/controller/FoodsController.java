package store.store_api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import store.store_api.dto.foods.AlterFoodsDTO;
import store.store_api.dto.foods.FoodsDTO;
import store.store_api.dto.foods.ListFoodsDTO;
import store.store_api.dto.foods.ResponseFoodsDTO;
import store.store_api.service.FoodsService;

import java.util.List;

@RestController
@RequestMapping("/foods")
@AllArgsConstructor
@Validated
public class FoodsController {

    private final FoodsService foodService;

    @GetMapping("/{id}")
    public ListFoodsDTO listFoods(@PathVariable String id) {
        return foodService.listFood(id);
    }

    @GetMapping
    public List<ListFoodsDTO> listAllFoods() {
        return foodService.listAllFoods();
    }

    @PostMapping
    public ResponseFoodsDTO foodsRegister(@RequestBody @Valid FoodsDTO foodsDTO) {
        return foodService.foodsRegister(foodsDTO);
    }

    @PutMapping
    public AlterFoodsDTO alterFood(@RequestBody @Valid AlterFoodsDTO alterFoodsDTO) {
            return foodService.alterFood(alterFoodsDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable String id) {
        foodService.deleteFood(id);
    }
}
