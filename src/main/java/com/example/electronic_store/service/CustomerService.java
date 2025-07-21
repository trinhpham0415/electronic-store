package com.example.electronic_store.service;

import com.example.electronic_store.service.receipt.ReceiptService;
import com.example.electronic_store.service.shopping_cart.ShoppingCartService;

public interface CustomerService extends ShoppingCartService, ReceiptService {
}
