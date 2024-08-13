package com.WebScrapingApp.data.repository;

import com.WebScrapingApp.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
