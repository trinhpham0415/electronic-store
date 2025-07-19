package com.example.electronic_store.service.product;

import com.example.electronic_store.entity.Category;
import com.example.electronic_store.entity.Product;
import com.example.electronic_store.exception.IllegalArgumentException;
import com.example.electronic_store.repository.CategoryRepository;
import com.example.electronic_store.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
@Service
public class ProductManipulationServiceImpl implements ProductManipulationService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Product addNewProduct(Product newProduct) {
        setCategory(newProduct);
        return productRepository.save(newProduct);
    }

    private void setCategory(Product newProduct) {
        Category newProductCategory = null;
        if ((newProductCategory = newProduct.getCategory()) != null) {
            Long categoryId;
            if ((categoryId = newProductCategory.getId()) != null) {
                newProductCategory = categoryRepository.findById(categoryId)
                        .orElseThrow(() -> new IllegalArgumentException("Category not found!"));
            } else if (StringUtils.hasText(newProductCategory.getName())) {
                newProductCategory = new Category();
                newProductCategory.setName(newProduct.getCategory().getName());
            } else newProductCategory = null;
            newProduct.setCategory(newProductCategory);
        }
    }

    @Override
    public void removeProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found!"));

        product.setCategory(null);
        productRepository.delete(product);
    }
}
