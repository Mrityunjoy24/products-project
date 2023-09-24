package com.mrityunjoy24.productservice3.thirdpartyClients;

import com.mrityunjoy24.productservice3.dtos.FakeStoreProductDto;
import com.mrityunjoy24.productservice3.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductClientService")
public class FakeStoreProductServiceClient implements ThirdPartyProductClientService {


    private final String fakeStoreApiUrl = "https://fakestoreapi.com/products";
    private final RestTemplateBuilder restTemplateBuilder;

    private FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> fakeStoreProductDto = restTemplate.getForEntity(fakeStoreApiUrl, FakeStoreProductDto[].class);

        List<FakeStoreProductDto> fakeStoreProductDto1 = new ArrayList<>();
        fakeStoreProductDto1 = List.of(fakeStoreProductDto.getBody());

        return fakeStoreProductDto1;
    }

    @Override
    public FakeStoreProductDto getProductById(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String fakeStoreApiGetUrl = this.fakeStoreApiUrl+"/{id}";
        ResponseEntity<FakeStoreProductDto> fakeStoreProduct = restTemplate.getForEntity(fakeStoreApiGetUrl, FakeStoreProductDto.class, productId);

        FakeStoreProductDto fakeStoreProductDto = fakeStoreProduct.getBody();
        return fakeStoreProductDto;
    }

    @Override
    public FakeStoreProductDto addProduct(FakeStoreProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> fakeStoreProduct = restTemplate.postForEntity(fakeStoreApiUrl, product, FakeStoreProductDto.class);
        return product;
    }
}
