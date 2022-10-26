package com.vendas.gestavendas.service.impl;

import com.vendas.gestavendas.entity.Category;
import com.vendas.gestavendas.repository.CategoryRepository;
import com.vendas.gestavendas.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryImpl implements CategoryService {
    private final CategoryRepository categoryRepository;


    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryByCode(Long code) {
        return categoryRepository.findByCode(code);
    }
}
