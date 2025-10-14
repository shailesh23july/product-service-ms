package com.scaler.productservice.services;

import com.scaler.productservice.dtos.CreateProductResponseDto;
import com.scaler.productservice.dtos.FakeStoreCreateProductRequestDto;
import com.scaler.productservice.dtos.FakeStoreCreateProductResponseDto;
import com.scaler.productservice.dtos.FakeStoreUpdateProductRequestDto;
import com.scaler.productservice.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakeStoreProductService")
@RequiredArgsConstructor
public class ProductServiceFakeStoreImpl implements ProductService {

    private final RestTemplate restTemplate;

    @Override
    public Product createProduct(Product product) {
        FakeStoreCreateProductRequestDto fakeStoreCreateProductDto = getFakeStoreCreateProductRequestDto(product);
        FakeStoreCreateProductResponseDto response = restTemplate.postForObject("https://fakestoreapi.com/products",
                fakeStoreCreateProductDto,
                FakeStoreCreateProductResponseDto.class);
        return toProduct(response);
    }

    @Override
    public List<Product> getProducts() {
        FakeStoreCreateProductResponseDto[] productResponsDtos = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreCreateProductResponseDto[].class);

        return List.of();
    }

    private static FakeStoreCreateProductRequestDto getFakeStoreCreateProductRequestDto(Product product) {
        FakeStoreCreateProductRequestDto fakeStoreCreateProductDto = new FakeStoreCreateProductRequestDto();
        fakeStoreCreateProductDto.setTitle(product.getTitle());
        fakeStoreCreateProductDto.setDescription(product.getDescription());
        fakeStoreCreateProductDto.setPrice(product.getPrice());

        fakeStoreCreateProductDto.setImage(product.getImageUrl());
        return fakeStoreCreateProductDto;
    }

    private static Product toProduct(FakeStoreCreateProductResponseDto response) {
        Product newProduct = new Product();
        newProduct.setId(response.getId());
        newProduct.setTitle(response.getTitle());
        newProduct.setDescription(response.getDescription());
        newProduct.setPrice(response.getPrice());

        newProduct.setImageUrl(response.getImage());
        return newProduct;
    }

    @Override
    public ProductServiceType getSupportedProductType() {
        return ProductServiceType.FAKESTORE_IMPLEMENTATION;
    }

    @Override
    public void deleteProduct(final Long productId) {
        restTemplate.delete("https://fakestoreapi.com/products/{id}", productId);
    }

    @Override
    public Product getProduct(final Long productId) {
        FakeStoreCreateProductResponseDto response = restTemplate.getForObject("https://fakestoreapi.com/products/{productId}", FakeStoreCreateProductResponseDto.class, productId);
        return toProduct(response);
    }

    @Override
    public void updateProduct(final Long productId, final CreateProductResponseDto productDto) {
        FakeStoreUpdateProductRequestDto productUpdateDto = new FakeStoreUpdateProductRequestDto();
        productUpdateDto.setId(productDto.getId());
        productUpdateDto.setCategory(productDto.getCategoryName());
        productUpdateDto.setImage(productDto.getImageUrl());
        productUpdateDto.setTitle(productDto.getTitle());
        productUpdateDto.setDescription(productDto.getDescription());
        productUpdateDto.setPrice(productDto.getPrice());
        restTemplate.put("https://fakestoreapi.com/products/{id}", productUpdateDto, productId);
    }

    @Override
    public void patchProduct(final Long productId, final CreateProductResponseDto productDto) {
    }
}
