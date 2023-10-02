package com.mrityunjoy24.productservice3.controllers;


import com.mrityunjoy24.productservice3.dtos.GenericCategoryDto;
import com.mrityunjoy24.productservice3.dtos.GenericProductDto;
import com.mrityunjoy24.productservice3.models.Category;
import com.mrityunjoy24.productservice3.services.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(@Qualifier("SelfCategoryService") CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/categories")
    public ResponseEntity<List<GenericCategoryDto>> getCategories() {

        List<GenericCategoryDto> genericCategoryDtos =  categoryService.getAllCategories();
        return ResponseEntity.ok(genericCategoryDtos);
    }

    @GetMapping("/category/{name}")
    public ResponseEntity<List<GenericProductDto>> getProductsByCategory(@PathVariable("name") String categoryName){

        List<GenericProductDto> productsByCategory = categoryService.getAllProductsByCategory(categoryName);
        return ResponseEntity.ok(productsByCategory);
    }
}
