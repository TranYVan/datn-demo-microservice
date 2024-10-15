package com.datn_microservices.order_service.mapper;

import com.datn_microservices.order_service.dto.OrderDto;
import com.datn_microservices.order_service.entities.Order;

public class OrderMapper {

    public static OrderDto map_to_dto(Order order, OrderDto order_dto) {
        order_dto.setOrder_id(order.getOrder_id());
        order_dto.setOrder_date(order.getOrder_date());
        order_dto.setItems(order.getItems());
        return order_dto;
    }

    public static Order map_to_entity(OrderDto orderDto, Order order) {
        order.setOrder_id(orderDto.getOrder_id());
        order.setOrder_date(orderDto.getOrder_date());
        order.setItems(orderDto.getItems());
        return order;
    }
}
