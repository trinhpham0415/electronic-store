package com.example.electronic_store.service;

import com.example.electronic_store.service.product.ProductManipulationService;
import com.example.electronic_store.service.product.ProductRetrievingService;

public interface AdminService extends ProductRetrievingService, ProductManipulationService {
}
