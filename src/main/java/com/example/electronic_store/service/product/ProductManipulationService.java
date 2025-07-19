package com.example.electronic_store.service.product;

import com.example.electronic_store.entity.Product;
import com.example.electronic_store.exception.IllegalArgumentException;

public interface ProductManipulationService {
    Product addNewProduct(Product product) throws IllegalArgumentException;
    void removeProductById(Long id) throws IllegalArgumentException;
}
