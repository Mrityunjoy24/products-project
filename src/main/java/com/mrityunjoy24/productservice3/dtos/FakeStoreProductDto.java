package com.mrityunjoy24.productservice3.dtos;

import com.mrityunjoy24.productservice3.models.BaseModel;
import com.mrityunjoy24.productservice3.models.Category;
import com.mrityunjoy24.productservice3.models.Rating;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto extends BaseModel {
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;
    private Rating rating;
}
