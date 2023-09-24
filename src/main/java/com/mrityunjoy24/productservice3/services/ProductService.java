package com.mrityunjoy24.productservice3.services;

import com.mrityunjoy24.productservice3.dtos.GenericAddProductDto;
import com.mrityunjoy24.productservice3.dtos.GenericProductDto;
import com.mrityunjoy24.productservice3.models.Product;

import java.util.List;


public interface ProductService {
    public List<GenericProductDto> getAllProducts();
    public GenericProductDto getProductById(Long productId);
    public GenericProductDto addProduct(GenericAddProductDto product);
}
