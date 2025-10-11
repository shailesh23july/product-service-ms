package com.scaler.productservice.dtos;

import lombok.Data;

@Data
public class FakeStoreCreateProductRequestDto {
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;
}
