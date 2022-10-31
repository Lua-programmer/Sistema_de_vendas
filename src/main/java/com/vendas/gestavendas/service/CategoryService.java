package com.vendas.gestavendas.service;

import com.vendas.gestavendas.entity.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {
    List<Category> getCategories();
    Optional<Category> getCategoryByCode(UUID code);

    Category saveCategory(Category category);

    Category updateCategory(UUID code, Category category);

    void deleteCategory(UUID code);
}
