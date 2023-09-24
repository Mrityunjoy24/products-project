package com.mrityunjoy24.productservice3.dtos;

import com.mrityunjoy24.productservice3.models.Rating;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private String name;
    private String description;
    private Double price;
    private String category;
    private Rating rating;
}
