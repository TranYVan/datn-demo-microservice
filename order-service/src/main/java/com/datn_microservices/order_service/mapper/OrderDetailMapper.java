package com.datn_microservices.order_service.mapper;

import com.datn_microservices.order_service.dto.OrderDetailDto;
import com.datn_microservices.order_service.dto.OrderDto;
import com.datn_microservices.order_service.entities.Order;
import com.datn_microservices.order_service.entities.Order_Detail;

public class OrderDetailMapper {
    public static OrderDetailDto map_to_dto(Order_Detail order_detail, OrderDetailDto orderDetailDto) {
        orderDetailDto.setOrder_dto();
        orderDetailDto.setQuantity(order_detail.getOrder_date());
        orderDetailDto.setProd_id(order_detail.getItems());
        return order_dto;
    }

    public static Order map_to_entity(OrderDto orderDto, Order order) {
        order.setOrder_id(orderDto.getOrder_id());
        order.setOrder_date(orderDto.getOrder_date());
        order.setItems(orderDto.getItems());
        return order;
    }
}
