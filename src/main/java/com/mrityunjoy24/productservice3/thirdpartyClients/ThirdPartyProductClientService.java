package com.mrityunjoy24.productservice3.thirdpartyClients;

import com.mrityunjoy24.productservice3.dtos.FakeStoreProductDto;

import java.util.List;

public interface ThirdPartyProductClientService {
    List<FakeStoreProductDto> getAllProducts();
    FakeStoreProductDto getProductById(Long productId);
    FakeStoreProductDto addProduct(FakeStoreProductDto product);
}
