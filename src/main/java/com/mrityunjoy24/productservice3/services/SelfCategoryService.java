package com.mrityunjoy24.productservice3.services;

import com.mrityunjoy24.productservice3.dtos.GenericCategoryDto;
import com.mrityunjoy24.productservice3.dtos.GenericProductDto;
import com.mrityunjoy24.productservice3.dtos.GenericRatingDto;
import com.mrityunjoy24.productservice3.models.Category;
import com.mrityunjoy24.productservice3.models.Product;
import com.mrityunjoy24.productservice3.repositories.CategoryRepository;
import com.mrityunjoy24.productservice3.repositories.ProductRepository;
import com.mrityunjoy24.productservice3.repositories.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("SelfCategoryService")
public class SelfCategoryService implements CategoryService{

    private final ProductRepository productRepository;
    private final RatingRepository ratingRepository;
    private final CategoryRepository categoryRepository;

    SelfCategoryService(ProductRepository  productRepository, RatingRepository ratingRepository, CategoryRepository categoryRepository){
        this.productRepository =productRepository;
        this.ratingRepository = ratingRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<GenericCategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<GenericCategoryDto> genericCategoryDtos = new ArrayList<>();

        for (Category category:categories) {
            GenericCategoryDto genericCategoryDto = new GenericCategoryDto();
            genericCategoryDto.setName(category.getName());
            genericCategoryDto.setDescription(category.getDescription());
            genericCategoryDtos.add(genericCategoryDto);
        }

        return genericCategoryDtos;
    }

    @Override
    public List<GenericProductDto> getAllProductsByCategory(String categoryName) {
        List<GenericProductDto> productsByCategory = new ArrayList<>();

        Category category1 = categoryRepository.findByName(categoryName);

        List<Product> productsByCategory1 = productRepository.findByCategory(category1);

        return getGenericProductDtos(productsByCategory, productsByCategory1);
    }

    static List<GenericProductDto> getGenericProductDtos(List<GenericProductDto> productsByCategory, List<Product> productsByCategory1) {
        for (Product product:productsByCategory1) {
            GenericProductDto genericProductDto = new GenericProductDto();
            genericProductDto.setTitle(product.getTitle());
            genericProductDto.setDescription(product.getDescription());

            GenericCategoryDto genericCategoryDto = new GenericCategoryDto();
            genericCategoryDto.setDescription(product.getCategory().getDescription());
            genericCategoryDto.setName(product.getCategory().getName());

            GenericRatingDto genericRatingDto = new GenericRatingDto();
            genericRatingDto.setRate(product.getRating().getRate());
            genericRatingDto.setCount(product.getRating().getCount());

            genericProductDto.setCategory(genericCategoryDto);
            genericProductDto.setPrice(product.getPrice());
            genericProductDto.setRating(genericRatingDto);

            productsByCategory.add(genericProductDto);
        }
        return productsByCategory;
    }
}
