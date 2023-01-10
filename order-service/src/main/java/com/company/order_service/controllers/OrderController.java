package com.company.order_service.controllers;

import com.company.order_service.model.OrderModel;
import com.company.order_service.service.OrderService;
import com.company.order_service.model.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/food")
    public Response<OrderModel> placeOrder(@RequestBody OrderModel orderModel){
        return new Response<>(orderService.placeOrder(orderModel));
    }

    @PutMapping("/complete/{id}")
    public Response<OrderModel> complete(@PathVariable Long id){
        return new Response<>(orderService.complete(id));
    }

    @PutMapping("/cancel/{id}")
    public Response<OrderModel> cancel(@PathVariable Long id){
        return new Response<>(orderService.cancel(id));
    }

    @GetMapping("/get/{id}")
    public Response<OrderModel> getById(@PathVariable Long id){
        return new Response<>(orderService.read(id));
    }

    @GetMapping("/get-all")
    public Response<List<OrderModel>> getAll(){
        return new Response<>(orderService.readAll());
    }

    @GetMapping("/get-all-waiting")
    public Response<List<OrderModel>> getAllWaiting(){
        return new Response<>(orderService.readAllWaiting());
    }
}