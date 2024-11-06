package com.datn_microservices.order_service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Data
@Embeddable
public class OrderDetailPK implements Serializable {

    @Column(name = "order_id")
    private Long order_id;

    @Column(name = "prod_id")
    private Long prod_id;
}
