package com.mrityunjoy24.productservice3.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Setter
@Getter
@Entity
public class Product extends BaseModel{
    private String title;
    private Double price;
    private String description;
    @ManyToOne()
    @Cascade(value = {CascadeType.PERSIST})
    private Category category;
    private String image;
    @OneToOne
    @Cascade(value = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Rating rating;
}
