package com.mrityunjoy24.productservice3.services;

import com.mrityunjoy24.productservice3.dtos.*;
import com.mrityunjoy24.productservice3.models.Product;
import com.mrityunjoy24.productservice3.models.Rating;
import com.mrityunjoy24.productservice3.thirdpartyClients.FakeStoreProductServiceClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private FakeStoreProductServiceClient fakeStoreProductServiceClient;
    private FakeStoreProductService(FakeStoreProductServiceClient  fakeStoreProductServiceClient){
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreProductServiceClient.getAllProducts();

        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtos){
            genericProductDtos.add(createProductFromFakeStoreProductDto(fakeStoreProductDto));
        }

        return genericProductDtos;
    }

    public GenericProductDto getProductById(String productId){
        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductServiceClient.getProductById(Long.parseLong(productId));
        GenericProductDto product = createProductFromFakeStoreProductDto(fakeStoreProductDto);
        return product;
    }

    @Override
    public GenericProductDto addProduct(GenericAddProductDto product) {

        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setId(UUID.randomUUID());
        fakeStoreProductDto.setCategory(product.getCategory());
        fakeStoreProductDto.setImage(product.getImage());
        fakeStoreProductDto.setPrice(123.4);

        Rating rating = new Rating();
        rating.setRate(0.0);
        rating.setCount(0L);

        fakeStoreProductDto.setRating(rating);
        fakeStoreProductServiceClient.addProduct(fakeStoreProductDto);


        return createProductFromFakeStoreProductDto(fakeStoreProductDto);
    }

    @Override
    public GenericProductDto updateProduct(String productId, GenericProductDto product) {
        return null;
    }

    @Override
    public String deleteProduct(String productId) {
        return  null;
    }

    public GenericProductDto createProductFromFakeStoreProductDto(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());


        GenericCategoryDto genericCategoryDto = new GenericCategoryDto();
        genericCategoryDto.setName(fakeStoreProductDto.getCategory().getName());
        genericCategoryDto.setDescription(fakeStoreProductDto.getCategory().getDescription());

        genericProductDto.setCategory(genericCategoryDto);

        Rating rating = new Rating();
        rating.setCount(fakeStoreProductDto.getRating().getCount());
        rating.setRate(fakeStoreProductDto.getRating().getRate());

        GenericRatingDto genericRatingDto = new GenericRatingDto();
        genericRatingDto.setRate(genericProductDto.getRating().getRate());
        genericRatingDto.setCount(genericProductDto.getRating().getCount());


        genericProductDto.setRating(genericRatingDto);
        return genericProductDto;
    }
}
