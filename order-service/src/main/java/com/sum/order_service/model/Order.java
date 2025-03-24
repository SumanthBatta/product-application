package com.sum.order_service.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;

import java.util.List;

@Entity
@Table(name="t_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String orderNumber;

    @OneToMany(cascade= CascadeType.ALL)
    private List<OrderLineItems> orderLineItemsList;



}
