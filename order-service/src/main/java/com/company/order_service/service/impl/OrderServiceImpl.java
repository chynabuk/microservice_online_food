package com.company.order_service.service.impl;

import com.company.order_service.entities.Food;
import com.company.order_service.entities.Order;
import com.company.order_service.entities.User;
import com.company.order_service.enums.Status;
import com.company.order_service.exceptions.OrderException;
import com.company.order_service.model.OrderModel;
//import com.company.order_service.query.FoodGetQuery;
//import com.company.order_service.query_gateway.FoodQueryGateway;
import com.company.order_service.repository.OrderRepository;
import com.company.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
//    private final FoodQueryGateway foodQueryGateway;
    private final RestTemplate restTemplate;

    @Override
    public OrderModel placeOrder(OrderModel orderModel) {
        Food food = getFood(orderModel.getFoodId());
        User user = getMyself(orderModel.getAuth());
        if (food != null && user != null){
            if (food.getPrice() <= 0) throw new OrderException("Food is not available");

            Order order = Order.builder()
                    .food(food)
                    .user(user)
                    .build();
            orderRepository.save(order);
            orderModel.setId(order.getId());
            orderModel.setUserId(user.getId());

            log.info("Order #" + order.getId() + " is placed");
            log.info(sendEmail("kushtarbekovkuba2002@gmail.com", "Order placing #" + order.getId(), user.getEmail() + " placed order of " + food));
        }

        return orderModel;
    }

    @Override
    public OrderModel complete(Long id) {
        Order order = get(id);
        if (order.getStatus() == Status.WAITING){
            order.setStatus(Status.COMPLETED);
            orderRepository.save(order);
            log.info("Order #" + order.getId() + " is completed");
            log.info(sendEmail(order.getUser().getEmail(), "Order completed #" + order.getId(), order.getFood() + "\nYour order is completed\n"));
        }
        return toModel(order);
    }

    @Override
    public OrderModel cancel(Long id) {
        Order order = get(id);
        if (order.getStatus() == Status.WAITING){
            order.setStatus(Status.CANCELLED);
            orderRepository.save(order);
            log.info("Order #" + order.getId() + " is cancelled");
            log.info(sendEmail(order.getUser().getEmail(), "Order cancelled #" + order.getId(), order.getFood() + "\nYour order is cancelled\n"));
        }
        return toModel(order);
    }

    @Override
    public OrderModel read(Long id) {
        return toModel(get(id));
    }

    @Override
    public List<OrderModel> readAll() {
        return orderRepository.findAll()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderModel> readAllWaiting() {
        return orderRepository.findWaitingOrders()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    private Order get(Long id){
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderException(" with id{" + id + "} was not found"));
    }

    private Food getFood(Long id){
        return restTemplate.getForObject("http://localhost:8085/api/food/get-" + id, Food.class);
    }

    private User getMyself(String auth){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", auth);

        HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);

        return restTemplate.exchange("http://localhost:8090/auth/get-myself2",
                HttpMethod.GET, httpEntity, User.class).getBody();
    }

    private OrderModel toModel(Order order){
        return OrderModel.builder()
                .id(order.getId())
                .userId(order.getUser().getId())
                .foodId(order.getFood().getId())
                .status(order.getStatus())
                .orderedDate(order.getOrderedDate())
                .build();
    }

    private String sendEmail(String to, String subject, String body){
        return restTemplate.exchange(
                String.format("http://localhost:8084/api/email/send?to=%s&subject=%s&body=%s", to, subject, body),
                HttpMethod.POST,
                null,
                String.class)
        .getBody();
    }
}
