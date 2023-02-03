package com.jeanpaul.exampleshop.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Entity
@Table(name="orders")
@Getter @Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    /**
     * 1:Ordered
     * 2:Packaging
     * 3:Shipping
     * 4:Delivered
     */
    private Integer state;
    private Double total;
    @Column(updatable = false)
    private Instant created;

    @OneToMany
    @JoinColumn(name="detailId")
    private Set<DetailsOrder> details;

    public Order() {
    }

    public Order(Integer state) {
        this.state = state;
    }
}
