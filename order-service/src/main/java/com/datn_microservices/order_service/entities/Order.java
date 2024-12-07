package com.datn_microservices.order_service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "\"order\"")
public class Order {

    @Id
    // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    // @SequenceGenerator(name = "orders_id_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long order_id;

    @Column(name = "order_date")
    private LocalDate order_date;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
    private List<Order_Detail> items = new ArrayList<>();
}
