package com.mrityunjoy24.productservice3.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Product extends BaseModel{
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;
    private Rating rating;
}
