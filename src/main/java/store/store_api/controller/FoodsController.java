package store.store_api.controller;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import store.store_api.dto.foods.AlterFoodsDTO;
import store.store_api.dto.foods.FoodsDTO;
import store.store_api.service.FoodService;

@Controller
@RequestMapping("foods")
public class FoodsController {

    @Autowired
    private FoodService foodService;

    @PostMapping
    public ResponseEntity foodsRegister(@RequestBody @Valid FoodsDTO foodsDTO) {
        try {
            return ResponseEntity.ok("Food create");
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity alterFood(@RequestBody @Valid AlterFoodsDTO alterFoodsDTO) {
        try {
            foodService.alterFood(alterFoodsDTO);
            return ResponseEntity.ok("Alter food");
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
