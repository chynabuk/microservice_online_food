package com.company.order_service.repository;

import com.company.order_service.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(nativeQuery = true, value = "select * from orders order by id desc ")
    @Override
    List<Order> findAll();

    @Query(nativeQuery = true, value = "select * from orders where status == 'WAITING'")
    List<Order> findWaitingOrders();
}
