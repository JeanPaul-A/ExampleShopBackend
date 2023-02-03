package com.jeanpaul.exampleshop.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="products")
@Getter @Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(nullable = false)
    private String name;
    private String description;
    private String category;
    private Long price;
    private Integer stock;

    @OneToOne
    private DetailsOrder detailsOrder;

    public Product() {
    }

    public Product(String name, String description, String category, Long price, Integer stock) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }
}
