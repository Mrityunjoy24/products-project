package com.mrityunjoy24.productservice3.services;

import com.mrityunjoy24.productservice3.dtos.GenericCategoryDto;
import com.mrityunjoy24.productservice3.dtos.GenericProductDto;
import com.mrityunjoy24.productservice3.models.Category;
import com.mrityunjoy24.productservice3.models.Product;

import java.util.List;

public interface CategoryService
{
    List<GenericCategoryDto> getAllCategories();
    List<GenericProductDto> getAllProductsByCategory(String category);
}
