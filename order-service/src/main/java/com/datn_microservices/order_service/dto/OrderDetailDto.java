package com.datn_microservices.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class OrderDetailDto {

    private Long order_id;
    private Long prod_id;
    private Long quantity;
}
