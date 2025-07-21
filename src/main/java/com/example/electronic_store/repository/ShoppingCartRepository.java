package com.example.electronic_store.repository;

import com.example.electronic_store.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    @Query("SELECT sc FROM ShoppingCart sc WHERE sc.customer.id = :customerId AND sc.checkedOut = false")
    Optional<ShoppingCart> getInProgressShoppingCart(Long customerId);

    @Query("SELECT sc FROM ShoppingCart sc WHERE sc.customer.id = :customerId AND sc.checkedOut = true")
    List<ShoppingCart> getAllReceiptsByCustomerId(Long customerId);
}
