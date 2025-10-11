package com.scaler.productservice.services;

import com.scaler.productservice.model.Product;
import org.springframework.stereotype.Service;

@Service("dbProductService")
public class ProductServiceDBImpl implements ProductService{


    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public ProductServiceType getSupportedProductType() {
        return ProductServiceType.DB_IMPLEMENTATION;
    }
}
