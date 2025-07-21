package com.example.electronic_store.service;

import com.example.electronic_store.dto.request.ShoppingCartProductAdding;
import com.example.electronic_store.dto.request.ShoppingCartProductRemoving;
import com.example.electronic_store.dto.response.Response;
import com.example.electronic_store.entity.ShoppingCart;
import com.example.electronic_store.service.receipt.ReceiptService;
import com.example.electronic_store.service.shopping_cart.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final ShoppingCartService shoppingCartService;
    private final ReceiptService receiptService;

    @Override
    public ShoppingCart produceReceipt(Long customerId) {
        return receiptService.produceReceipt(customerId);
    }

    @Override
    public Response addProductToShoppingCart(Long customerId, ShoppingCartProductAdding productAdding) {
        return shoppingCartService.addProductToShoppingCart(customerId, productAdding);
    }

    @Override
    public Response removeProductFromShoppingCart(Long customerId, ShoppingCartProductRemoving productRemoving) {
        return shoppingCartService.removeProductFromShoppingCart(customerId, productRemoving);
    }

    @Override
    public ShoppingCart getInProgressShoppingCart(Long customerId) {
        return shoppingCartService.getInProgressShoppingCart(customerId);
    }

    @Override
    public List<ShoppingCart> getAllReceipts(Long customerId) {
        return shoppingCartService.getAllReceipts(customerId);
    }
}
