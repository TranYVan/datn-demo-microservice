package com.datn_microservices.order_service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter @Getter @ToString
@AllArgsConstructor @NoArgsConstructor
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_id_seq")
    @Column(name = "order_id")
    private Long order_id;

    @Column(name = "order_date")
    private LocalDate order_date;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY,
                cascade = CascadeType.PERSIST, targetEntity = Order_Detail.class)
    private List<Order_Detail> items;
}
