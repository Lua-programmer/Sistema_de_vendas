package com.vendas.gestavendas.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.vendas.gestavendas.entity.Category;
import com.vendas.gestavendas.repository.CategoryRepository;
import com.vendas.gestavendas.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryImpl implements CategoryService {
    private final CategoryRepository categoryRepository;


    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryByCode(UUID code) {
        return categoryRepository.findByCode(code);
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(UUID code, Category category) {
        Category categorySaved = validateCategory(code);
        BeanUtils.copyProperties(category, categorySaved, "code");
        return categoryRepository.save(categorySaved);
    }

    private Category validateCategory(UUID code) {
        Optional<Category> categoryByCode = getCategoryByCode(code);
        if (categoryByCode.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return categoryByCode.get();
    }

//    @Override
//    public void deleteCategory(UUID code) {
//    }
}
