package com.example.electronic_store.service.shopping_cart;

import com.example.electronic_store.dto.request.ShoppingCartProductAdding;
import com.example.electronic_store.dto.request.ShoppingCartProductRemoving;
import com.example.electronic_store.dto.response.Response;
import com.example.electronic_store.entity.Customer;
import com.example.electronic_store.entity.OrderItem;
import com.example.electronic_store.entity.Product;
import com.example.electronic_store.entity.ShoppingCart;
import com.example.electronic_store.exception.IllegalArgumentException;
import com.example.electronic_store.exception.ResourceNotFoundException;
import com.example.electronic_store.repository.CustomerRepository;
import com.example.electronic_store.repository.ProductRepository;
import com.example.electronic_store.repository.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public Response addProductToShoppingCart(Long customerId, ShoppingCartProductAdding productAdding) {
        Customer customer = customerRepository.findById(customerId)
            .orElseThrow(() -> new ResourceNotFoundException("Customer not found!"));

        Product product = productRepository.findById(productAdding.getProductId())
           .orElseThrow(() -> new ResourceNotFoundException("Product not found!"));

        if (product.getStock() < productAdding.getQuantity()) {
            throw new IllegalArgumentException("Insufficient stock!");
        }

        ShoppingCart shoppingCart = customer.getShoppingCarts().stream()
                .filter(cart -> !cart.isCheckedOut())
                .findFirst()
                .orElseGet(ShoppingCart::new);

        OrderItem orderItem = shoppingCart.getOrderItems().stream()
            .filter(item -> item.getProduct().equals(product))
            .findFirst()
            .orElseGet(OrderItem::new);
        orderItem.setProduct(product);
        if (orderItem.getId() == null) {
            orderItem.setQuantity(productAdding.getQuantity());
        } else {
            orderItem.setQuantity(orderItem.getQuantity() + productAdding.getQuantity());
        }
        orderItem.setShoppingCart(shoppingCart);
        shoppingCart.getOrderItems().add(orderItem);
        if (shoppingCart.getId() == null) {
            shoppingCart.setCustomer(customer);
        }
        shoppingCartRepository.save(shoppingCart);

        //Decrease product's stock
        product.setStock(product.getStock() - productAdding.getQuantity());
        productRepository.save(product);

        return new Response("Product was added to Shopping Cart!", shoppingCart);
    }

    @Override
    @Transactional
    public Response removeProductFromShoppingCart(Long customerId, ShoppingCartProductRemoving productRemoving) {
        Customer customer = customerRepository.findById(customerId)
            .orElseThrow(() -> new ResourceNotFoundException("Customer not found!"));

        ShoppingCart shoppingCart = customer.getShoppingCarts().stream()
            .filter(cart -> !cart.isCheckedOut())
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(
                "This customer does not have any in-progress Shopping Cart!")
            );

        Product product = productRepository.findById(productRemoving.getProductId())
            .orElseThrow(() -> new ResourceNotFoundException("Product not found!"));

        OrderItem orderItem = shoppingCart.getOrderItems()
            .stream().filter(item -> item.getProduct().equals(product))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("The product is not existed in Shopping Cart of this Customer"));

        orderItem.setShoppingCart(null);
        shoppingCart.getOrderItems().remove(orderItem);
        shoppingCartRepository.save(shoppingCart);

        //Increase product's stock
        product.setStock(product.getStock() + orderItem.getQuantity());
        productRepository.save(product);

        return new Response("Product was removed from Shopping Cart!", shoppingCart);
    }

    @Override
    public ShoppingCart getInProgressShoppingCart(Long customerId) {
        return shoppingCartRepository.getInProgressShoppingCart(customerId)
            .orElseThrow(() -> new IllegalArgumentException(
                "This customer does not have any in-progress Shopping Cart!")
            );
    }

    @Override
    public List<ShoppingCart> getAllReceipts(Long customerId) {
        return shoppingCartRepository.getAllReceiptsByCustomerId(customerId);
    }
}
