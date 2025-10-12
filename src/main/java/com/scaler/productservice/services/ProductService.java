package com.scaler.productservice.services;

import com.scaler.productservice.dtos.CreateProductResponseDto;
import com.scaler.productservice.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getProducts();

    ProductServiceType getSupportedProductType();

    void deleteProduct(Long productId);

    Product getProduct(Long productId);

    void updateProduct(Long productId, CreateProductResponseDto productDto);

    void patchProduct(Long productId, CreateProductResponseDto productDto);
}
