package com.example.electronic_store.service.product;

import com.example.electronic_store.entity.Product;

import java.util.List;

public interface ProductRetrievingService {
    List<Product> getAllProducts(int page);
}