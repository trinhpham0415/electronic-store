package com.example.electronic_store.controller;

import com.example.electronic_store.entity.ShoppingCart;
import com.example.electronic_store.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer/{customerId}/receipts")
@RequiredArgsConstructor
public class CustomerReceiptController {
    private final CustomerService customerService;

    @PostMapping
    public ShoppingCart produceReceipt(@PathVariable Long customerId) {
        return customerService.produceReceipt(customerId);
    }

    @GetMapping
    public List<ShoppingCart> getAllReceipts(@PathVariable Long customerId) {
        return customerService.getAllReceipts(customerId);
    }
}
