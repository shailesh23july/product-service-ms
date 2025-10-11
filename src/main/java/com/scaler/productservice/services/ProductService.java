package com.scaler.productservice.services;

import com.scaler.productservice.model.Product;

public interface ProductService {

    Product createProduct(Product product);

    ProductServiceType getSupportedProductType();
}
