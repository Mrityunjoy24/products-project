package com.mrityunjoy24.productservice3.services;

import com.mrityunjoy24.productservice3.dtos.GenericAddProductDto;
import com.mrityunjoy24.productservice3.dtos.GenericCategoryDto;
import com.mrityunjoy24.productservice3.dtos.GenericProductDto;
import com.mrityunjoy24.productservice3.models.Category;
import com.mrityunjoy24.productservice3.models.Product;

import java.util.List;


public interface ProductService {
    public List<GenericProductDto> getAllProducts();
    public GenericProductDto getProductById(String productId);
    public GenericProductDto addProduct(GenericAddProductDto product);
    public GenericProductDto updateProduct(String productId, GenericProductDto product);
    public String deleteProduct(String productId);
}
