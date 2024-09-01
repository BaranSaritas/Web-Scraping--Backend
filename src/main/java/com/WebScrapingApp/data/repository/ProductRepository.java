package com.WebScrapingApp.data.repository;

import com.WebScrapingApp.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ProductRepository extends JpaRepository<Product,Long> {

    boolean existsByBrandAndNameAndSubCategoryAndDate(String brand, String name, String subCategory, LocalDate today);
}
