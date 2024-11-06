package com.datn_microservices.order_service.mapper;

import com.datn_microservices.order_service.dto.OrderDetailDto;
import com.datn_microservices.order_service.dto.OrderDto;
import com.datn_microservices.order_service.entities.Order;
import com.datn_microservices.order_service.entities.OrderDetailPK;
import com.datn_microservices.order_service.entities.Order_Detail;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    // Convert Order entity to OrderDto
    public static OrderDto toOrderDto(Order order) {
        OrderDto dto = new OrderDto();
        dto.setOrder_id(order.getOrder_id());
        dto.setOrder_date(order.getOrder_date());

        List<OrderDetailDto> itemDtos = order.getItems().stream()
                .map((Order_Detail orderDetail) -> toOrderDetailDto(orderDetail))
                .collect(Collectors.toList());
        dto.setItems(itemDtos);

        return dto;
    }

    // Convert OrderDetail entity to OrderDetailDto
    public static OrderDetailDto toOrderDetailDto(Order_Detail orderDetail) {
        OrderDetailDto dto = new OrderDetailDto();
        dto.setOrder_id(orderDetail.getId().getOrder_id());
        dto.setProd_id(orderDetail.getId().getProd_id());
        dto.setQuantity(orderDetail.getQuantity());

        return dto;
    }

    // Convert OrderDto to Order entity
    public static Order toOrderEntity(OrderDto dto) {
        Order order = new Order();
        order.setOrder_id(dto.getOrder_id());
        order.setOrder_date(dto.getOrder_date());

        List<Order_Detail> items = dto.getItems().stream()
                .map(itemDto -> toOrderDetailEntity(itemDto, order))
                .collect(Collectors.toList());
        order.setItems(items);

        return order;
    }

    // Convert OrderDetailDto to OrderDetail entity
    public static Order_Detail toOrderDetailEntity(OrderDetailDto dto, Order order) {
        Order_Detail orderDetail = new Order_Detail();

        OrderDetailPK pk = new OrderDetailPK();
        pk.setOrder_id(dto.getOrder_id());
        pk.setProd_id(dto.getProd_id());

        orderDetail.setId(pk);
        orderDetail.setOrder(order);
        orderDetail.setQuantity(dto.getQuantity());

        return orderDetail;
    }
}
