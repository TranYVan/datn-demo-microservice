package com.datn_microservices.order_service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class OrderDetailPk implements Serializable {

    private Long order_id;
    private Long prod_id;
    // equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailPk that = (OrderDetailPk) o;
        return Objects.equals(order_id, that.order_id) &&
                Objects.equals(prod_id, that.prod_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id, prod_id);
    }
}
