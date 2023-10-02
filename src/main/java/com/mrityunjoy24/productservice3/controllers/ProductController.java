package com.mrityunjoy24.productservice3.controllers;

import com.mrityunjoy24.productservice3.dtos.GenericAddProductDto;
import com.mrityunjoy24.productservice3.dtos.GenericProductDto;
import com.mrityunjoy24.productservice3.models.Rating;
import com.mrityunjoy24.productservice3.repositories.RatingRepository;
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
    public ProductController(@Qualifier("SelfProductService") ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<GenericProductDto>> getAllProducts(){
        List<GenericProductDto> products =  productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericProductDto> getProductById(@PathVariable(value = "id") String productId){
        GenericProductDto product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/add")
    public ResponseEntity<GenericProductDto> addProduct(@RequestBody GenericAddProductDto product){
        GenericProductDto newGenericProductDto = productService.addProduct(product);
        return ResponseEntity.ok(newGenericProductDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(value = "id") String productId){
        String response = productService.deleteProduct(productId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericProductDto> updateProduct(@PathVariable("id") String id,@RequestBody GenericProductDto genericProductDto){
        GenericProductDto genericProductDto1 = productService.updateProduct(id,genericProductDto);
        return ResponseEntity.ok(genericProductDto1);
    }

}
