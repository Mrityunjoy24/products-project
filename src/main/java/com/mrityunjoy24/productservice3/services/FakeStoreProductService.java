package com.mrityunjoy24.productservice3.services;

import com.mrityunjoy24.productservice3.dtos.FakeStoreProductDto;
import com.mrityunjoy24.productservice3.dtos.GenericAddProductDto;
import com.mrityunjoy24.productservice3.dtos.GenericProductDto;
import com.mrityunjoy24.productservice3.models.Product;
import com.mrityunjoy24.productservice3.models.Rating;
import com.mrityunjoy24.productservice3.thirdpartyClients.FakeStoreProductServiceClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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

    public GenericProductDto getProductById(Long productId){
        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductServiceClient.getProductById(productId);
        GenericProductDto product = createProductFromFakeStoreProductDto(fakeStoreProductDto);
        return product;
    }

    @Override
    public GenericProductDto addProduct(GenericAddProductDto product) {

        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setId(1134L);
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


    public GenericProductDto createProductFromFakeStoreProductDto(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto product = new GenericProductDto();
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());

        Rating rating = new Rating();
        rating.setCount(fakeStoreProductDto.getRating().getCount());
        rating.setRate(fakeStoreProductDto.getRating().getRate());

        product.setRating(rating);
        return product;
    }
}
