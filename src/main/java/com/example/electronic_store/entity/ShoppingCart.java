package com.example.electronic_store.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity

@Table(name = "shopping_cart")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class ShoppingCart extends AuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "checked_out")
    private boolean checkedOut;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("shoppingCart")
    private Set<OrderItem> orderItems = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("shoppingCarts")
    private Customer customer;
}
