package com.mrityunjoy24.productservice3.controllers;

import com.mrityunjoy24.productservice3.dtos.GenericProductDto;
import com.mrityunjoy24.productservice3.dtos.ProductDto;
import com.mrityunjoy24.productservice3.models.Product;
import com.mrityunjoy24.productservice3.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    public ProductService productService;

    @Value("${productService.type}")
    private String productServiceName;
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products =  productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable(value = "id") Long productId){
        Product product = productService.getProductById(productId);

        ProductDto productDto = new ProductDto();
        productDto.setName(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setRating(product.getRating());
        productDto.setCategory(product.getCategory());

        return ResponseEntity.ok(productDto);
    }

    @PostMapping("/add")
    public ResponseEntity<GenericProductDto> addProduct(@RequestBody GenericProductDto product){
        GenericProductDto newGenericProductDto = productService.addProduct(product);
        return ResponseEntity.ok(newGenericProductDto);
    }
}
