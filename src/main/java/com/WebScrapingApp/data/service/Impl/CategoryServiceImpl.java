package com.WebScrapingApp.data.service.Impl;

import com.WebScrapingApp.data.dto.request.CategoryCreateDto;
import com.WebScrapingApp.data.dto.request.CategoryDto;
import com.WebScrapingApp.data.dto.request.TitleCreateDTO;
import com.WebScrapingApp.data.model.Category;
import com.WebScrapingApp.data.repository.CategoryRepository;
import com.WebScrapingApp.data.service.CategoryService;
import com.WebScrapingApp.data.service.TitleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final TitleService titleService;

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public Category getRCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return category;
    }

    @Override
    public CategoryDto createCategory(CategoryCreateDto categoryCreateDTO) {
        Category category = modelMapper.map(categoryCreateDTO, Category.class);
        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryCreateDto categoryCreateDTO) {
        Category category = modelMapper.map(categoryCreateDTO, Category.class);
        category.setId(id); // Ensure the ID is set for update
        Category updatedCategory = categoryRepository.save(category);
        return modelMapper.map(updatedCategory, CategoryDto.class);
    }
    @Override
    public List<CategoryDto> createCategories(List<CategoryCreateDto> categoryCreateDTOs) {
        List<CategoryDto> createdCategories = new ArrayList<>();

        for (CategoryCreateDto categoryCreateDTO : categoryCreateDTOs) {
            // Check if the category already exists
            Category existingCategory = categoryRepository.findByCategoryName(categoryCreateDTO.getCategoryName());
            if (existingCategory == null) {
                // If not exists, create and save the new category
                Category category = modelMapper.map(categoryCreateDTO, Category.class);
                Category savedCategory = categoryRepository.save(category);

                // title altindaki linkleri kaydet



                CategoryDto categoryDto = modelMapper.map(savedCategory, CategoryDto.class);
                categoryDto.setTitleIds(categoryCreateDTO.getTitleIds());
                createdCategories.add(categoryDto);
            } else {
                // If exists, return the existing category
                CategoryDto categoryDto = modelMapper.map(existingCategory, CategoryDto.class);
                createdCategories.add(categoryDto);
            }
        }
        createdCategories.forEach(i-> {
                    i.getTitleIds().forEach(title -> {

                        TitleCreateDTO titleCreateDTO = new TitleCreateDTO();
                        titleCreateDTO.setCategoryId(i.getId() );
                        titleCreateDTO.setTitleName(title.getTitleName());
                        titleCreateDTO.setTitleUrl(title.getTitleUrl());
                        titleService.createTitle(titleCreateDTO);

                        title.getSubTitleList().forEach(subTitleDTO -> {

                        });

                    });
                }
        );

        return createdCategories;
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
