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

import static com.scaler.productservice.services.ProductServiceType.DB_IMPLEMENTATION;
import static com.scaler.productservice.services.ProductServiceType.FAKESTORE_IMPLEMENTATION;

@RestController
@RequestMapping("/products/v2")
public class ProductControllerV2 {

    private Map<ProductServiceType, ProductService> productServiceMap;

    public ProductControllerV2(List<ProductService> productServiceList) {
        productServiceMap = productServiceList.stream().collect(Collectors.toMap(ProductService::getSupportedProductType, Function.identity()));
    }

    @PostMapping
    public CreateProductResponseDto createProduct(final @RequestBody CreateProductRequestDto createProductRequestDto) {
        Product product = productServiceMap.get(DB_IMPLEMENTATION).createProduct(createProductRequestDto.toProduct());
        return CreateProductResponseDto.fromProduct(product);
    }

    @PutMapping("/{productId}")
    public void updateProduct(final @PathVariable("productId") Long productId, final @RequestBody CreateProductResponseDto productResponseDto) {
        productServiceMap.get(DB_IMPLEMENTATION).updateProduct(productId, productResponseDto);
    }

    @GetMapping
    public List<CreateProductResponseDto> getAllProducts() {
        List<Product> products = productServiceMap.get(DB_IMPLEMENTATION).getProducts();
        return products.stream().map(CreateProductResponseDto::fromProduct).toList();
    }

    @GetMapping("/{productId}")
    public Product getSingleProduct(final @PathVariable("productId") Long productId) {
        return productServiceMap.get(DB_IMPLEMENTATION).getProduct(productId);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(final @PathVariable("productId") Long productId) {
        productServiceMap.get(DB_IMPLEMENTATION).deleteProduct(productId);
    }
}
