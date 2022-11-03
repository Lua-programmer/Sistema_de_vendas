package com.vendas.gestavendas.controller;


import com.vendas.gestavendas.controller.dto.category.CategoryRequestDTO;
import com.vendas.gestavendas.controller.dto.category.CategoryResponseDTO;
import com.vendas.gestavendas.entity.Category;
import com.vendas.gestavendas.service.impl.CategoryImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.ServerVariable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryImpl categoryService;

    @Operation(summary = "List All")
    @GetMapping
    public List<CategoryResponseDTO> getCategories() {
        return categoryService.getCategories().stream().map(category -> CategoryResponseDTO.convertForDTO(category)).collect(Collectors.toList());
    }

    @Operation(summary = "List by Code")
    @GetMapping("category/{code}")
    public ResponseEntity<CategoryResponseDTO> getCategoryByCode(@PathVariable UUID code) {
        Optional<Category> category = categoryService.getCategoryByCode(code);
        return category.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(CategoryResponseDTO.convertForDTO(category.get()));
    }

    @Operation(summary = "Create a new category")
    @PostMapping
    public ResponseEntity<CategoryResponseDTO> saveCategory(@Valid @RequestBody CategoryRequestDTO categoryDto) {
        Category categorySaved = categoryService.saveCategory(categoryDto.convertForEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryResponseDTO.convertForDTO(categorySaved));
    }

    @Operation(summary = "Update category")
    @PutMapping("category/{code}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable UUID code, @Valid @RequestBody CategoryRequestDTO categoryDto) {
        Category categoryUpdated = categoryService.updateCategory(code, categoryDto.convertForEntity(code));
        return ResponseEntity.ok(CategoryResponseDTO.convertForDTO(categoryUpdated));
    }

    @Operation(summary = "Delete category")
    @DeleteMapping("category/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable UUID code){
        categoryService.deleteCategory(code);
    }
}
