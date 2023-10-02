package com.mrityunjoy24.productservice3;

import com.mrityunjoy24.productservice3.models.Category;
import com.mrityunjoy24.productservice3.models.Product;
import com.mrityunjoy24.productservice3.models.Rating;
import com.mrityunjoy24.productservice3.repositories.CategoryRepository;
import com.mrityunjoy24.productservice3.repositories.ProductRepository;
import com.mrityunjoy24.productservice3.repositories.RatingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductService3Application implements CommandLineRunner {

    private RatingRepository ratingRepository;
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    ProductService3Application(RatingRepository ratingRepository, ProductRepository productRepository, CategoryRepository categoryRepository){
        this.ratingRepository = ratingRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductService3Application.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
//        Rating rating = new Rating();
//        rating.setCount(0L);
//        rating.setRate(0.0);
//        ratingRepository.save(rating);
//
//
//        Product product = new Product();
//        product.setTitle("iphone");
//        product.setDescription("iphone is the best iphone");
//
//        Category category = new Category();
//        category.setName("Phones");
//        category.setDescription("All phones");
////        categoryRepository.save(category);
//
//        product.setCategory(category);
//        product.setRating(rating);
//        product.setImage("google.com");
//        product.setPrice(159900.0);
//        productRepository.save(product);
    }
}
