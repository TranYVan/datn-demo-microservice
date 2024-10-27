package com.datn_microservices.order_service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDetailResponseDto implements Serializable {
    private ProductDto data;
    private String status;
}
