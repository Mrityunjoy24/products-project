package com.mrityunjoy24.productservice3.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GenericRatingDto {
    private Double rate;
    private Long count;
}
