package com.mrityunjoy24.productservice3.repositories;

import com.mrityunjoy24.productservice3.models.Category;
import com.mrityunjoy24.productservice3.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findByCategory(Category category);
}
