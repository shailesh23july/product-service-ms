package com.scaler.productservice.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
public class Product extends BaseModel {

    private String title;

    private String description;

    private double price;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Category category;

    private String imageUrl;
}
