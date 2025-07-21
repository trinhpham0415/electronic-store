package com.example.electronic_store.service.discount;

import com.example.electronic_store.entity.Discount;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DiscountServiceImpl implements DiscountService {
    @Override
    public boolean isDiscountValid(Discount discount) {
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(discount.getStartDate()) && now.isBefore(discount.getEndDate());
    }
}
