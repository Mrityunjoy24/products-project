package com.mrityunjoy24.productservice3.dtos;


import com.mrityunjoy24.productservice3.models.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GenericAddProductDto {
    private String title;
    private Double price;
    private String description;
    private String image;
    private Category category;
}
