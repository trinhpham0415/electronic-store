package com.example.electronic_store.service;

import com.example.electronic_store.entity.Product;
import com.example.electronic_store.service.product.ProductManipulationService;
import com.example.electronic_store.service.product.ProductRetrievingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final ProductRetrievingService productRetrievingService;
    private final ProductManipulationService productManipulationService;

    @Override
    public List<Product> getAllProducts(int page) {
        return productRetrievingService.getAllProducts(page);
    }

    @Override
    public Product addNewProduct(Product newProduct) {
        return productManipulationService.addNewProduct(newProduct);
    }

    @Override
    public void removeProductById(Long id) {
        productManipulationService.removeProductById(id);
    }
}
