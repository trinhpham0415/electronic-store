package com.example.electronic_store.service.receipt;

import com.example.electronic_store.entity.Product;
import com.example.electronic_store.entity.ShoppingCart;
import com.example.electronic_store.exception.IllegalArgumentException;
import com.example.electronic_store.repository.ShoppingCartRepository;
import com.example.electronic_store.service.discount.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReceiptServiceImpl implements ReceiptService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final DiscountService discountService;

    @Override
    @Transactional
    public ShoppingCart produceReceipt(Long customerId) {
        ShoppingCart shoppingCart = shoppingCartRepository.getInProgressShoppingCart(customerId)
            .orElseThrow(() -> new IllegalArgumentException(
                "This customer does not have any in progress Shopping Cart to produce receipt!")
            );
        double totalPrice = shoppingCart.getOrderItems().stream()
            .mapToDouble(item -> getPriceAppliedDiscounts(item.getProduct()) * item.getQuantity())
            .sum();
        shoppingCart.setTotalPrice(totalPrice);
        shoppingCart.setCheckedOut(true);
        shoppingCartRepository.save(shoppingCart);
        return shoppingCart;
    }

    private double getPriceAppliedDiscounts(Product product) {
        double totalDiscountedAmount = product.getDiscounts().stream()
            .filter(discountService::isDiscountValid)
            .mapToDouble(discount -> product.getPrice() * ((double) discount.getPercent() / 100))
            .sum();
        return product.getPrice() - totalDiscountedAmount;
    }
}
