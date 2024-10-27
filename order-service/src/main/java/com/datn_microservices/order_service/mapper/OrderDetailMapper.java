package com.datn_microservices.order_service.mapper;

import com.datn_microservices.order_service.dto.OrderDetailDto;
import com.datn_microservices.order_service.dto.OrderDto;
import com.datn_microservices.order_service.entities.Order;
import com.datn_microservices.order_service.entities.Order_Detail;

public class OrderDetailMapper {
    public static OrderDetailDto map_to_dto(Order_Detail order_detail, OrderDetailDto orderDetailDto) {
        orderDetailDto.setOrder_id(order_detail.getOrder().getOrder_id());
        orderDetailDto.setQuantity(order_detail.getQuantity());
        orderDetailDto.setProd_id(order_detail.getProd_id());
        return orderDetailDto;
    }

    public static Order_Detail map_to_entity(OrderDetailDto orderDetailDto, Order_Detail order_detail) {
        Order order = new Order();
        order.setOrder_id(orderDetailDto.getOrder_id());

        order_detail.setOrder(order);
        order_detail.setQuantity(orderDetailDto.getQuantity());
        order_detail.setProd_id(orderDetailDto.getProd_id());
        return order_detail;
    }
}
