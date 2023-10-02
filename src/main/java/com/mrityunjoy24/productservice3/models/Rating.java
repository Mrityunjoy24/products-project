package com.mrityunjoy24.productservice3.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Rating extends BaseModel {
    private Double rate;
    private Long count;
}
