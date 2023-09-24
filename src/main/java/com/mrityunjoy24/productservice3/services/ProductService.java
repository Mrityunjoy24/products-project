package com.mrityunjoy24.productservice3.services;

import com.mrityunjoy24.productservice3.dtos.GenericProductDto;
import com.mrityunjoy24.productservice3.models.Product;

import java.util.List;


public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProductById(Long productId);
    public GenericProductDto addProduct(GenericProductDto product);
}
