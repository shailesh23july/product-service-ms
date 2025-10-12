package com.scaler.productservice.dtos;

import lombok.Data;

@Data
public class FakeStoreUpdateProductRequestDto {

    private Long id;
    private String title;
    private String description;
    private double price;
    private String category;
    private String image;
}
