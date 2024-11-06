package com.datn_microservices.order_service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "order_detail")
public class Order_Detail {

    @EmbeddedId
    private OrderDetailPK id;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @MapsId("order_id")
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "quantity")
    private Long quantity;
}
