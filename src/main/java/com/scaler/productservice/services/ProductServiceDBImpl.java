package com.scaler.productservice.services;

import com.scaler.productservice.dtos.CreateProductResponseDto;
import com.scaler.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dbProductService")
public class ProductServiceDBImpl implements ProductService{


    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return List.of();
    }

    @Override
    public ProductServiceType getSupportedProductType() {
        return ProductServiceType.DB_IMPLEMENTATION;
    }

    @Override
    public void deleteProduct(Long productId) {

    }

    @Override
    public Product getProduct(Long productId) {
        return null;
    }

    @Override
    public void updateProduct(final Long productId, final CreateProductResponseDto productDto) {
    }

    @Override
    public void patchProduct(final Long productId, final CreateProductResponseDto productDto) {
    }
}
