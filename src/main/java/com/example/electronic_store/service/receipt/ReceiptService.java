package com.example.electronic_store.service.receipt;

import com.example.electronic_store.entity.ShoppingCart;

public interface ReceiptService {
    ShoppingCart produceReceipt(Long customerId);
}
