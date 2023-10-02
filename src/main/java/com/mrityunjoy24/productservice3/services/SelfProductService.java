package com.mrityunjoy24.productservice3.services;

import com.mrityunjoy24.productservice3.dtos.GenericAddProductDto;
import com.mrityunjoy24.productservice3.dtos.GenericCategoryDto;
import com.mrityunjoy24.productservice3.dtos.GenericProductDto;
import com.mrityunjoy24.productservice3.dtos.GenericRatingDto;
import com.mrityunjoy24.productservice3.exceptions.NotFoundException;
import com.mrityunjoy24.productservice3.models.Category;
import com.mrityunjoy24.productservice3.models.Product;
import com.mrityunjoy24.productservice3.models.Rating;
import com.mrityunjoy24.productservice3.repositories.CategoryRepository;
import com.mrityunjoy24.productservice3.repositories.ProductRepository;
import com.mrityunjoy24.productservice3.repositories.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.mrityunjoy24.productservice3.services.SelfCategoryService.getGenericProductDtos;

@Service("SelfProductService")
public class SelfProductService implements ProductService{
    private final ProductRepository productRepository;
    private final RatingRepository ratingRepository;
    private final CategoryRepository categoryRepository;

    SelfProductService(ProductRepository  productRepository, RatingRepository ratingRepository, CategoryRepository categoryRepository){
        this.productRepository =productRepository;
        this.ratingRepository = ratingRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<GenericProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<GenericProductDto> genericProductDtos = new ArrayList<>();

        return getGenericProductDtos(genericProductDtos, products);
    }

    @Override
    public GenericProductDto getProductById(String productId) throws NotFoundException {

        UUID uuid = UUID.fromString(productId);
        Optional<Product> product1 = productRepository.findById(uuid);

        if (product1.isEmpty()){
            throw new NotFoundException("Product not found");
        }

        Product product = product1.get();

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

        return genericProductDto;
    }

    @Override
    public GenericProductDto addProduct(GenericAddProductDto genericAddProductDto) {

        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setTitle(genericAddProductDto.getTitle());
        product.setDescription(genericAddProductDto.getDescription());
        product.setImage(genericAddProductDto.getImage());
        product.setCategory(genericAddProductDto.getCategory());
        product.setPrice(genericAddProductDto.getPrice());


        Category category = categoryRepository.findByName(genericAddProductDto.getCategory().getName());
        if (category == null) {
            category = new Category();
            category.setName(genericAddProductDto.getCategory().getName());
            category.setDescription(genericAddProductDto.getCategory().getDescription());
            categoryRepository.save(category);
        }

        product.setCategory(category);
        Rating rating = new Rating();
        rating.setRate(0.0);
        rating.setCount(0L);
        ratingRepository.save(rating);

        product.setRating(rating);

        productRepository.save(product);
        GenericProductDto genericProductDto = new GenericProductDto();

        genericProductDto.setTitle(product.getTitle());
        genericProductDto.setDescription(product.getDescription());
        genericProductDto.setPrice(product.getPrice());

        GenericCategoryDto genericCategoryDto = new GenericCategoryDto();
        genericCategoryDto.setDescription(product.getCategory().getDescription());
        genericCategoryDto.setName(product.getCategory().getName());

        GenericRatingDto genericRatingDto = new GenericRatingDto();
        genericRatingDto.setRate(product.getRating().getRate());
        genericRatingDto.setCount(product.getRating().getCount());

        genericProductDto.setRating(genericRatingDto);
        genericProductDto.setCategory(genericCategoryDto);

        return genericProductDto;
    }

    @Override
    public GenericProductDto updateProduct(String productId, GenericProductDto genericProductDto) {
        Optional<Product> productById = productRepository.findById(UUID.fromString(productId));

        Product product = productById.get();

        product.setTitle(genericProductDto.getTitle());

        product.setDescription(genericProductDto.getDescription());

        Category category = new Category();
        category.setDescription(genericProductDto.getCategory().getDescription());
        category.setName(genericProductDto.getCategory().getName());

        GenericRatingDto genericRatingDto = new GenericRatingDto();
        genericRatingDto.setRate(product.getRating().getRate());
        genericRatingDto.setCount(product.getRating().getCount());

        product.setCategory(category);

        product.setPrice(genericProductDto.getPrice());


        productRepository.save(product);

        genericProductDto.setRating(genericRatingDto);
        return genericProductDto;
    }

    @Override
    public String deleteProduct(String productId) {
        productRepository.deleteById(UUID.fromString(productId));
        return "Product deleted successfully";
    }
}
