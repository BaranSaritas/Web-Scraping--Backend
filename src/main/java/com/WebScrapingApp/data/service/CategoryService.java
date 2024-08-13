package com.WebScrapingApp.data.service;

import com.WebScrapingApp.data.dto.request.CategoryCreateDto;
import com.WebScrapingApp.data.dto.request.CategoryDto;
import com.WebScrapingApp.data.model.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories();

    CategoryDto getCategoryById(Long id);

    Category getRCategoryById(Long id);

    CategoryDto createCategory(CategoryCreateDto categoryCreateDTO);

    CategoryDto updateCategory(Long id, CategoryCreateDto categoryCreateDTO);

    List<CategoryDto> createCategories(List<CategoryCreateDto> categoryCreateDTOs);

    void deleteCategory(Long id);
}
