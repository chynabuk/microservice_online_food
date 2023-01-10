package com.company.food_online_service.service.impl;

//import com.company.food_online_service.commands.FoodGetCommand;
//import com.company.food_online_service.query.FoodGetQuery;
//import org.axonframework.commandhandling.CommandHandler;
//import org.axonframework.queryhandling.QueryHandler;
import com.company.food_online_service.entity.Food;
import com.company.food_online_service.exceptions.FoodException;
import com.company.food_online_service.model.FoodModel;
import com.company.food_online_service.repository.FoodRepository;
import com.company.food_online_service.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;

    @Override
    public FoodModel create(FoodModel foodModel) {
        Food food = Food.builder()
                .name(foodModel.getName())
                .description(foodModel.getDescription())
                .mass(foodModel.getMass())
                .price(foodModel.getPrice())
                .build();
        foodRepository.save(food);
        foodModel.setId(food.getId());

        return foodModel;
    }

    @Override
    public FoodModel update(FoodModel foodModel) {
        Food food = getFoodById(foodModel.getId());

        Float price = foodModel.getPrice();
        Float mass = foodModel.getMass();
        String description = foodModel.getDescription();
        String name = foodModel.getName();

        if (price != null){
            if (price.compareTo(food.getPrice()) != 0){
                food.setPrice(price);
            }
        }
        if (mass != null){
            if (mass.compareTo(food.getMass()) != 0){
                food.setMass(mass);
            }
        }
        if (description != null || !description.isEmpty()){
            food.setDescription(description);
        }
        if (name != null || !name.isEmpty()){
            food.setName(name);
        }
        foodRepository.save(food);
        return foodModel;
    }

    @Override
    public FoodModel read(Long id) {
        return toModel(getFoodById(id));
    }

    @Override
    public List<FoodModel> readAll() {
        return foodRepository.findAll().stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public String delete(Long id) {
        foodRepository.delete(getFoodById(id));
        return "Food with id[" + id + "] was deleted";
    }

//    @QueryHandler
//    @Override
//    public Food getFoodByQuery(FoodGetQuery foodGetQuery) {
//        return getFoodById(foodGetQuery.getId());
//    }

//    @Override
//    public Food getFoodByCommand(FoodGetCommand foodGetCommand) {
//        return getFoodById(foodGetCommand.getId());
//    }

    @Override
    public Food getFoodById(Long id){
        return foodRepository.findById(id)
                .orElseThrow(() -> new FoodException("Food is not found"));
    }

    private FoodModel toModel(Food food){
        return FoodModel.builder()
                .id(food.getId())
                .name(food.getName())
                .description(food.getDescription())
                .mass(food.getMass())
                .price(food.getPrice())
                .build();
    }
}
