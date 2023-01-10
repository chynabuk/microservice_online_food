//package com.company.order_service.query_gateway.impl;
//
//import com.company.order_service.entities.Food;
//import com.company.order_service.query.FoodGetQuery;
//import com.company.order_service.query_gateway.FoodQueryGateway;
//import lombok.RequiredArgsConstructor;
//import org.axonframework.queryhandling.QueryGateway;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.CompletableFuture;
//
//@Component
//@RequiredArgsConstructor
//public class FoodQueryGatewayImpl implements FoodQueryGateway {
//    private final QueryGateway queryGateway;
//
//    @Override
//    public CompletableFuture<Food> getFoodByQuery(FoodGetQuery foodGetQuery) {
//        return queryGateway.query(foodGetQuery, Food.class);
//    }
//}