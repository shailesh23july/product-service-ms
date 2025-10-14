package com.scaler.productservice.repository;

import com.scaler.productservice.model.Category;
import com.scaler.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product save(Product product );

    void delete(Product product);

    @Override
    List<Product> findAll();
}
