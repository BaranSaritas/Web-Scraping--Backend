package com.WebScrapingApp.data.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String brand;
    private String name;
    private String subCategory;
    private int favoriteCount;
    private float ratingScore;
    private BigDecimal price;
    private Long titleId; // Assuming Title entity has an ID field
}