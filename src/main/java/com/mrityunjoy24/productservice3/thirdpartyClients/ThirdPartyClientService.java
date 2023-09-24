package com.mrityunjoy24.productservice3.thirdpartyClients;

import com.mrityunjoy24.productservice3.dtos.FakeStoreProductDto;
import com.mrityunjoy24.productservice3.models.Product;

import java.util.List;

public interface ThirdPartyClientService {
    public List<FakeStoreProductDto> getProducts();
    public FakeStoreProductDto getProductById(Long productId);
    public FakeStoreProductDto addProduct(FakeStoreProductDto product);
}
