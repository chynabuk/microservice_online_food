//package com.company.food_online_service.aggregate;
//
//import com.company.food_online_service.commands.FoodGetCommand;
//import com.company.food_online_service.entity.Food;
//import com.company.food_online_service.service.FoodService;
//import lombok.*;
//import org.axonframework.commandhandling.CommandHandler;
//import org.axonframework.spring.stereotype.Aggregate;
//
//@Aggregate
//@NoArgsConstructor
//@Getter
//@Setter
//@RequiredArgsConstructor
//public class FoodAggregate {
//    private FoodService foodService;
//
//    @CommandHandler
//    public Food on(FoodGetCommand foodGetCommand){
//        return foodService.getFoodById(foodGetCommand.getId());
//    }
//}
