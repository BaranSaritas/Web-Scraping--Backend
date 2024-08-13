package com.WebScrapingApp.data.service;

import com.WebScrapingApp.data.dto.request.ProductCreateDTO;
import com.WebScrapingApp.data.dto.request.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(Long id);

    ProductDTO createProduct(ProductCreateDTO productCreateDTO);

    ProductDTO updateProduct(Long id, ProductCreateDTO productCreateDTO);

    void deleteProduct(Long id);
}
