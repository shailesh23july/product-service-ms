package com.scaler.productservice.dtos;

import com.scaler.productservice.model.Product;
import lombok.Data;

@Data
public class CreateProductResponseDto {
    private Long id;
    private String imageUrl;
    private String title;
    private String description;
    private double price;
    private String categoryName;

    public static CreateProductResponseDto fromProduct(Product product)  {
        CreateProductResponseDto productResponseDto = new CreateProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setImageUrl(product.getImageUrl());
        productResponseDto.setTitle(product.getTitle());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setCategoryName(product.getCategoryName());
        return productResponseDto;
    }
}
