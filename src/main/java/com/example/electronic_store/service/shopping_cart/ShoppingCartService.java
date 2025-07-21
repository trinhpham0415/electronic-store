package com.example.electronic_store.service.shopping_cart;

import com.example.electronic_store.dto.request.ShoppingCartProductAdding;
import com.example.electronic_store.dto.request.ShoppingCartProductRemoving;
import com.example.electronic_store.dto.response.Response;
import com.example.electronic_store.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    Response addProductToShoppingCart(Long customerId, ShoppingCartProductAdding productAdding);
    Response removeProductFromShoppingCart(Long customerId, ShoppingCartProductRemoving productRemoving);
    ShoppingCart getInProgressShoppingCart(Long customerId);
    List<ShoppingCart> getAllReceipts(Long customerId);
}
