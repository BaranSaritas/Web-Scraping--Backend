package com.WebScrapingApp.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String name;
    private String subCategory;
    private int favoriteCount;
    private float ratingScore;
    private int ratingCount;
    private BigDecimal price;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name="sub_title_id",referencedColumnName = "id")
    private SubTitle subtitle;
}
