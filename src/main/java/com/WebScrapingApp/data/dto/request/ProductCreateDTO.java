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
public class ProductCreateDTO {
    private String brand;
    private String name;
    private String subCategory;
    private int favoriteCount;
    private int ratingCount =0;
    private float ratingScore;
    private BigDecimal price;
    private Long titleId;
}