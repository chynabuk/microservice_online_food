package com.company.food_online_service.controller;

import com.company.food_online_service.model.FoodModel;
import com.company.food_online_service.service.FoodService;
import com.company.food_online_service.util.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/food")
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;

    @PostMapping("/create")
    public Response<FoodModel> create(@RequestBody FoodModel foodModel){
        return new Response<>(foodService.create(foodModel));
    }

    @GetMapping("/get/{id}")
    public Response<FoodModel> getById(@PathVariable Long id){
        return new Response<>(foodService.read(id));
    }

}
