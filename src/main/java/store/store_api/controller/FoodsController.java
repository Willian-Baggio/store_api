package store.store_api.controller;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import store.store_api.dto.foods.AlterFoodsDTO;
import store.store_api.dto.foods.FoodsDTO;
import store.store_api.service.FoodService;

@RestController
@RequestMapping("foods")
public class FoodsController {

    @Autowired
    private FoodService foodService;

    @PostMapping
    public ResponseEntity foodsRegister(@RequestBody @Valid FoodsDTO foodsDTO, UriComponentsBuilder uriBuilder) {
        try {
            var dto = foodService.createFood(foodsDTO);
            var uri = uriBuilder.path("/foods/{id}").buildAndExpand(dto.getId()).toUri();

            return ResponseEntity.created(uri).body(dto);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity alterFood(@RequestBody @Valid AlterFoodsDTO alterFoodsDTO) {
        try {
            var dto = foodService.alterFood(alterFoodsDTO);
            return ResponseEntity.ok(dto);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFood(@PathVariable Long id) {
        try {
            foodService.deleteFood(id);
            return ResponseEntity.noContent().build();
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
