package com.vendas.gestavendas.service;

import com.vendas.gestavendas.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getCategories();
    Optional<Category> getCategoryByCode(Long code);
}
