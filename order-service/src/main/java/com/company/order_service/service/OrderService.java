package com.company.order_service.service;

import com.company.order_service.model.OrderModel;

import java.util.List;

public interface OrderService {
    OrderModel placeOrder(OrderModel orderModel);
    OrderModel complete(Long id);
    OrderModel cancel(Long id);
    OrderModel read(Long id);
    List<OrderModel> readAll();
    List<OrderModel> readAllWaiting();


}