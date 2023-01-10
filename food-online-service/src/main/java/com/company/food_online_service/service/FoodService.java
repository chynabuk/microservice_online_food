package com.company.food_online_service.service;

//import com.company.food_online_service.commands.FoodGetCommand;
import com.company.food_online_service.entity.Food;
import com.company.food_online_service.model.FoodModel;
//import com.company.food_online_service.query.FoodGetQuery;

import java.util.List;

public interface FoodService {
    FoodModel create(FoodModel foodModel);
    FoodModel update(FoodModel foodModel);
    FoodModel read(Long id);
    Food getFoodById(Long id);
    List<FoodModel> readAll();
    String delete(Long id);
//    Food getFoodByQuery(FoodGetQuery foodGetQuery);
//    Food getFoodByCommand(FoodGetCommand foodGetCommand);
}