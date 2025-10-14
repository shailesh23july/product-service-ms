package com.scaler.productservice.repository;

import com.scaler.productservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category save(Category category);

    void delete(Category category);

    Optional<Category> findByName(String name);
}
