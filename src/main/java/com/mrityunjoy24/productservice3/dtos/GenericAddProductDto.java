package com.mrityunjoy24.productservice3.dtos;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GenericAddProductDto {
    private String title;
    private Double price;
    private String description;
    private String image;
    private String category;
}
