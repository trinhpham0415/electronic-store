package com.example.electronic_store.controller;

import com.example.electronic_store.entity.ShoppingCart;
import com.example.electronic_store.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer/{customerId}")
@RequiredArgsConstructor
public class CustomerShoppingCartController {
    private final CustomerService customerService;

    @GetMapping("shopping-cart")
    public ShoppingCart getInProgressShoppingCart(@PathVariable Long customerId) {
        return customerService.getInProgressShoppingCart(customerId);
    }
}
