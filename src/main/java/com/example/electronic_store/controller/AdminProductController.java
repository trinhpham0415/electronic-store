package com.example.electronic_store.controller;

import com.example.electronic_store.entity.Product;
import com.example.electronic_store.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("admin/products")
@RestController
public class AdminProductController {
    private final AdminService adminService;

    @GetMapping
    public List<Product> getAllProducts(@RequestParam int page) {
        return adminService.getAllProducts(page);
    }

    @PostMapping
    public Product addNewProduct(@RequestBody Product product) {
        return adminService.addNewProduct(product);
    }

    @DeleteMapping("/{id}")
    public void removeProduct(@PathVariable Long id) {
        adminService.removeProductById(id);
    }
}
