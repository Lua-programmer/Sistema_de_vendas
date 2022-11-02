package com.vendas.gestavendas.service.impl;

import com.vendas.gestavendas.entity.Product;
import com.vendas.gestavendas.exception.RuleBusinessException;
import com.vendas.gestavendas.repository.ProductRepository;
import com.vendas.gestavendas.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryImpl categoryService;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductByCode(UUID code) {
        return productRepository.findById(code);
    }

    @Override
    public Product saveProduct(Product product) {
        validateExistingProductCategory(product.getCategory().getCode());
        validateDuplicateCategoryCode(product);
        return productRepository.save(product);
    }

    private void validateDuplicateCategoryCode(Product product) {
        if (productRepository.findByCategoryCodeAndDescription(product.getCategory().getCode(), product.getDescription()).isPresent()) {
            throw new RuleBusinessException(String.format("The product [ %s ] is already registered", product.getDescription()));
        }
    }

    private void validateExistingProductCategory(UUID code) {
        if (code == null) {
            throw new RuleBusinessException("Category code must not be null");
        }
        if (categoryService.getCategoryByCode(code).isEmpty()) {
            throw new RuleBusinessException(String.format("Category code %s not exists", code));
        }
    }
}
