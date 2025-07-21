package com.example.electronic_store.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Table(name = "customers")
@Entity
@NoArgsConstructor
@JsonIgnoreProperties("user")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer")
    private Set<ShoppingCart> shoppingCarts = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Customer(String name, User user) {
        this.name = name;
        this.user = user;
    }
}
