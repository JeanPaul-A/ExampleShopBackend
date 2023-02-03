package com.jeanpaul.exampleshop.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "detailsOrder")
@Getter
@Setter
public class DetailsOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detailsId;

    @ManyToOne
    @JoinColumn(name="detailId", insertable = false, updatable = false)
    private Order order;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productID", referencedColumnName = "productId")
    private Product product;

    private Integer cant;

    public DetailsOrder() {
    }

    public DetailsOrder(Integer cant) {
        this.cant = cant;
    }
}
