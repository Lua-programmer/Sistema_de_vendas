package com.vendas.gestavendas.controller;


import com.vendas.gestavendas.entity.Category;
import com.vendas.gestavendas.service.impl.CategoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/v1/categories")
public class CategoryController {
    private final CategoryImpl categoryService;

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/api/v1/category/{code}")
    public ResponseEntity<Optional<Category>> getCategoryByCode(@PathVariable UUID code) {
        Optional<Category> category = categoryService.getCategoryByCode(code);
        return category.isPresent() ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        Category categorySaved = categoryService.saveCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(categorySaved);
    }
}
