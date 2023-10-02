package com.mrityunjoy24.productservice3.repositories;

import com.mrityunjoy24.productservice3.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RatingRepository extends JpaRepository<Rating, UUID> {

}
