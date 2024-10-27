package com.datn_microservices.order_service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_detail")
@IdClass(OrderDetailPk.class)
public class Order_Detail {

    @Column(name = "order_id")
    private Long order_id;

    @Id
    @Column(name = "prod_id")
    private Long prod_id;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false, insertable = false, updatable = false)
    private Order order;

    @Column(name = "quantity")
    private Long quantity;
}
