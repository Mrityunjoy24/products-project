package com.mrityunjoy24.productservice3.services;

import com.mrityunjoy24.productservice3.dtos.FakeStoreProductDto;
import com.mrityunjoy24.productservice3.dtos.GenericProductDto;
import com.mrityunjoy24.productservice3.models.Product;
import com.mrityunjoy24.productservice3.models.Rating;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private final String fakeStoreApiUrl = "https://fakestoreapi.com/products";
    private final RestTemplateBuilder restTemplateBuilder;

    private FakeStoreProductService(RestTemplateBuilder RestTemplateBuilder){
        this.restTemplateBuilder = RestTemplateBuilder;
    }

    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> fakeStoreProducts = restTemplate.getForEntity(fakeStoreApiUrl, FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProducts.getBody()) {
            products.add(createProductFromFakeStoreProductDto(fakeStoreProductDto));
        }

        return products;
    }

    public Product getProductById(Long productId){
        RestTemplate restTemplate = restTemplateBuilder.build();
        String fakeStoreApiGetUrl = this.fakeStoreApiUrl+"/{id}";
        ResponseEntity<FakeStoreProductDto> fakeStoreProduct = restTemplate.getForEntity(fakeStoreApiGetUrl, FakeStoreProductDto.class, productId);

        FakeStoreProductDto fakeStoreProductDto = fakeStoreProduct.getBody();
        return createProductFromFakeStoreProductDto(fakeStoreProductDto);
    }

    @Override
    public GenericProductDto addProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> fakeStoreProduct = restTemplate.postForEntity(fakeStoreApiUrl, product, FakeStoreProductDto.class);
        return product;
    }


    public Product createProductFromFakeStoreProductDto(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImage(fakeStoreProductDto.getImage());
        product.setCategory(fakeStoreProductDto.getCategory());

        Rating rating = new Rating();
        rating.setCount(fakeStoreProductDto.getRating().getCount());
        rating.setRate(fakeStoreProductDto.getRating().getRate());

        product.setRating(rating);
        return product;
    }
}
