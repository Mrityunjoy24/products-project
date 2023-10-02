package com.mrityunjoy24.productservice3.repositories;

import com.mrityunjoy24.productservice3.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

    public Category findByName(String name);
}
