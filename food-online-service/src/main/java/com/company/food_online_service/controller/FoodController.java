package com.company.food_online_service.controller;

import com.company.food_online_service.entity.Food;
import com.company.food_online_service.model.FoodModel;
import com.company.food_online_service.service.FoodService;
import com.company.food_online_service.model.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;

    @PostMapping("/create")
    public Response<FoodModel> create(@RequestBody FoodModel foodModel){
        return new Response<>(foodService.create(foodModel));
    }

    @PutMapping("/update")
    public Response<FoodModel> update(@RequestBody FoodModel foodModel){
        return new Response<>(foodService.update(foodModel));
    }

    @DeleteMapping("/delete/{id}")
    public Response<String> delete(@PathVariable Long id){
        return new Response<>(foodService.delete(id));
    }

    @GetMapping("/get/{id}")
    public Response<FoodModel> getById(@PathVariable Long id){
        return new Response<>(foodService.read(id));
    }

    @GetMapping("/get-all")
    public Response<List<FoodModel>> getAll(){
        return new Response<>(foodService.readAll());
    }

    @GetMapping("/get-{id}")
    public Food getFoodById(@PathVariable Long id){
        return foodService.getFoodById(id);
    }

}
