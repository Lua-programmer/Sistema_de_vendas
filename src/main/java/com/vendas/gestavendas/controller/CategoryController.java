package com.vendas.gestavendas.controller;


import com.vendas.gestavendas.entity.Category;
import com.vendas.gestavendas.service.impl.CategoryImpl;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryImpl categoryService;

    @Operation(summary = "To List")
    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @Operation(summary = "List by Code")
    @GetMapping("category/{code}")
    public ResponseEntity<Optional<Category>> getCategoryByCode(@PathVariable UUID code) {
        Optional<Category> category = categoryService.getCategoryByCode(code);
        return category.isPresent() ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Create a new category")
    @PostMapping
    public ResponseEntity<Category> saveCategory(@Valid @RequestBody Category category) {
        Category categorySaved = categoryService.saveCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(categorySaved);
    }

    @Operation(summary = "Update category")
    @PutMapping("category/{code}")
    public ResponseEntity<Category> updateCategory(@PathVariable UUID code, @Valid @RequestBody Category category) {
        return ResponseEntity.ok(categoryService.updateCategory(code, category));
    }

    @Operation(summary = "Delete category")
    @DeleteMapping("category/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable UUID code){
        categoryService.deleteCategory(code);
    }
}
