package com.scaler.productservice.controllers;


import com.scaler.productservice.dtos.CreateProductRequestDto;
import com.scaler.productservice.dtos.CreateProductResponseDto;
import com.scaler.productservice.model.Product;
import com.scaler.productservice.services.ProductService;
import com.scaler.productservice.services.ProductServiceType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public void getAllProducts() {

    }

    @GetMapping("/{productId}")
    public void getSingleProduct(final @PathVariable("productId") Long productId) {

    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(final @PathVariable("productId") String productId) {
    }
}
