package com.company.food_online_service.service;

import com.company.food_online_service.entity.Food;
import com.company.food_online_service.model.FoodModel;

import java.util.List;

public interface FoodService {
    FoodModel create(FoodModel foodModel);
    FoodModel update(FoodModel foodModel);
    FoodModel read(Long id);
    List<FoodModel> readAll();
    String delete(Long id);
}