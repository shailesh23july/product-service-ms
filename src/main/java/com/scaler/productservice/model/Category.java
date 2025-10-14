package com.scaler.productservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Data
@Entity
@SuperBuilder
@NoArgsConstructor
public class Category extends BaseModel {

    private String name;

    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
