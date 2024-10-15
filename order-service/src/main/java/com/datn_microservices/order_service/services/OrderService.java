package com.datn_microservices.order_service.services;

import com.datn_microservices.order_service.entities.Order;
import com.datn_microservices.order_service.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderService {

    private OrderRepository orderRepository;

    public void createOrder(Order order) {

        Order saved_order = orderRepository.save(order);
    }
}
