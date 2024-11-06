package com.datn_microservices.order_service.dto;

import com.datn_microservices.order_service.entities.Order_Detail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderDto {

    private Long order_id;
    private LocalDate order_date;

    private List<OrderDetailDto> items;
}
