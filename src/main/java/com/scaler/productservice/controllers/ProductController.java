package com.scaler.productservice.controllers;


import com.scaler.productservice.dtos.CreateProductRequestDto;
import com.scaler.productservice.dtos.CreateProductResponseDto;
import com.scaler.productservice.model.Product;
import com.scaler.productservice.services.ProductService;
import com.scaler.productservice.services.ProductServiceType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.scaler.productservice.services.ProductServiceType.FAKESTORE_IMPLEMENTATION;

@RestController
@RequestMapping("/products")
public class ProductController {

    private Map<ProductServiceType, ProductService> productServiceMap;

    public ProductController(List<ProductService> productServiceList) {
        productServiceMap = productServiceList.stream().collect(Collectors.toMap(ProductService::getSupportedProductType, Function.identity()));
    }

    @PostMapping
    public CreateProductResponseDto createProduct(final @RequestBody CreateProductRequestDto createProductRequestDto) {
        Product product = productServiceMap.get(FAKESTORE_IMPLEMENTATION).createProduct(createProductRequestDto.toProduct());
        return CreateProductResponseDto.fromProduct(product);
    }

    @PutMapping("/{productId}")
    public void updateProduct(final @PathVariable("productId") Long productId, final @RequestBody CreateProductResponseDto productResponseDto) {
        productServiceMap.get(FAKESTORE_IMPLEMENTATION).updateProduct(productId, productResponseDto);
    }

    @GetMapping
    public void getAllProducts() {

    }

    @GetMapping("/{productId}")
    public Product getSingleProduct(final @PathVariable("productId") Long productId) {
        return productServiceMap.get(FAKESTORE_IMPLEMENTATION).getProduct(productId);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(final @PathVariable("productId") Long productId) {
        productServiceMap.get(FAKESTORE_IMPLEMENTATION).deleteProduct(productId);
    }
}
