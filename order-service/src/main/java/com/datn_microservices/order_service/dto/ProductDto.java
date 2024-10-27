package com.datn_microservices.order_service.dto;

import lombok.Data;

@Data
public class ProductDto {
    private long id;
    private String prod_name;
    private Long stock_quantity;
}
