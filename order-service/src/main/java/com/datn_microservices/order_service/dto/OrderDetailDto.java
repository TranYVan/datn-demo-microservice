package com.datn_microservices.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class OrderDetailDto {

    private OrderDto order_dto;
    private Long prod_id;
    private Long quantity;
}
