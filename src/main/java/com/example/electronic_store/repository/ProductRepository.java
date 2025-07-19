package com.example.electronic_store.repository;

import com.example.electronic_store.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p LEFT JOIN FETCH p.discounts")
    List<Product> findAllWithDiscounts(Pageable pageable);
}
