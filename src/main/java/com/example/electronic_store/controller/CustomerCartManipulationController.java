package com.example.electronic_store.controller;

import com.example.electronic_store.dto.request.ShoppingCartProductAdding;
import com.example.electronic_store.dto.request.ShoppingCartProductRemoving;
import com.example.electronic_store.dto.response.Response;
import com.example.electronic_store.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer/{customerId}/shopping-cart/products")
@RequiredArgsConstructor
public class CustomerCartManipulationController {
    private final CustomerService customerService;

    @PostMapping
    public Response addProductToShoppingCart(@PathVariable Long customerId, @RequestBody ShoppingCartProductAdding productAdding) {
        return customerService.addProductToShoppingCart(customerId, productAdding);
    }

    @DeleteMapping
    public Response removeProductFromShoppingCart(@PathVariable Long customerId, @RequestBody ShoppingCartProductRemoving productRemoving) {
        return customerService.removeProductFromShoppingCart(customerId, productRemoving);
    }
}
