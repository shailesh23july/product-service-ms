package com.scaler.productservice.services;

import com.scaler.productservice.dtos.CreateProductResponseDto;
import com.scaler.productservice.model.Category;
import com.scaler.productservice.model.Product;
import com.scaler.productservice.repository.CategoryRepository;
import com.scaler.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dbProductService")
@RequiredArgsConstructor
public class ProductServiceDBImpl implements ProductService{


    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Product createProduct(Product product) {
//        Category productCategory = categoryRepository.findByName(product.getCategory().getName()).orElseGet(() -> {
//            Category category = Category.builder().name(product.getCategory().getName()).build();
//            return categoryRepository.save(category);
//        });
//        product.setCategory(productCategory);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
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
