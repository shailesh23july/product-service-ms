package com.scaler.productservice.dtos;

import com.scaler.productservice.model.Category;
import com.scaler.productservice.model.Product;
import lombok.Data;

@Data
public class CreateProductRequestDto {
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String categoryName;

    public Product toProduct() {
        Product product = new Product();
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.imageUrl);
        Category category = Category.builder().name(this.categoryName).build();
        product.setCategory(category);
        return product;
    }
}
