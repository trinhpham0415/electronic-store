package com.example.electronic_store.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Table(name = "products")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonIgnoreProperties("products")
    private Category category;

    private double price;

    private Long stock;

    @ManyToMany
    @JoinTable(
        name = "product_discount",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "discount_id")
    )
    @JsonIgnoreProperties("products")
    private Set<Discount> discounts;
}
