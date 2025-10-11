package com.scaler.productservice.services;

import com.scaler.productservice.dtos.FakeStoreCreateProductRequestDto;
import com.scaler.productservice.dtos.FakeStoreCreateProductResponseDto;
import com.scaler.productservice.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
@RequiredArgsConstructor
public class ProductServiceFakeStoreImpl implements ProductService {

    private final RestTemplate restTemplate;

    @Override
    public Product createProduct(Product product) {
        FakeStoreCreateProductRequestDto fakeStoreCreateProductDto = new FakeStoreCreateProductRequestDto();
        fakeStoreCreateProductDto.setTitle(product.getTitle());
        fakeStoreCreateProductDto.setDescription(product.getDescription());
        fakeStoreCreateProductDto.setPrice(product.getPrice());
        fakeStoreCreateProductDto.setCategory(product.getCategoryName());
        fakeStoreCreateProductDto.setImage(product.getImageUrl());
        FakeStoreCreateProductResponseDto response = restTemplate.postForObject("https://fakestoreapi.com/product",
                fakeStoreCreateProductDto,
                FakeStoreCreateProductResponseDto.class);
        Product newProduct = new Product();
        newProduct.setId(response.getId());
        newProduct.setTitle(response.getTitle());
        newProduct.setDescription(response.getDescription());
        newProduct.setPrice(response.getPrice());
        newProduct.setCategoryName(response.getCategory());
        return newProduct;
    }

    @Override
    public ProductServiceType getSupportedProductType() {
        return ProductServiceType.FAKESTORE_IMPLEMENTATION;
    }
}
