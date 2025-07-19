package com.example.electronic_store.service.product;

import com.example.electronic_store.entity.Product;
import com.example.electronic_store.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductRetrievingServiceImpl implements ProductRetrievingService {
    private final ProductRepository productRepository;

    @Value("${pagination.pageSize}")
    private String pageSize;

    @Override
    public List<Product> getAllProducts(int page) {
        Pageable pageRequest = PageRequest.of(page, Integer.parseInt(pageSize));
        return productRepository.findAllWithDiscounts(pageRequest);
    }
}
