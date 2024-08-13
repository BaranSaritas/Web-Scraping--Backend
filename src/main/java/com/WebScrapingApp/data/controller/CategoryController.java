package com.WebScrapingApp.data.controller;

import com.WebScrapingApp.data.dto.request.CategoryCreateDto;
import com.WebScrapingApp.data.dto.request.CategoryDto;
import com.WebScrapingApp.data.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categoryDTOs = categoryService.getAllCategories();
        return ResponseEntity.ok(categoryDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) {
        CategoryDto categoryDTO = categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryDTO);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryCreateDto categoryCreateDTO) {
        CategoryDto categoryDTO = categoryService.createCategory(categoryCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryDTO);
    }
    @PostMapping("/list")
    public ResponseEntity<List<CategoryDto>> createCategories(@RequestBody List<CategoryCreateDto> categoryCreateDTOs) {
        List<CategoryDto> categoryDTOs = categoryService.createCategories(categoryCreateDTOs);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryDTOs);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long id, @RequestBody CategoryCreateDto categoryCreateDTO) {
        CategoryDto categoryDTO = categoryService.updateCategory(id, categoryCreateDTO);
        return ResponseEntity.ok(categoryDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
