package com.vendas.gestavendas.service.impl;

import com.vendas.gestavendas.entity.Product;
import com.vendas.gestavendas.exception.RuleBusinessException;
import com.vendas.gestavendas.repository.ProductRepository;
import com.vendas.gestavendas.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryImpl categoryService;

    @Override
    public List<Product> getProducts(UUID categoryCode) {
        return productRepository.findByCategoryCode(categoryCode);
    }

    @Override
    public Optional<Product> getByCodeCategory(UUID code, UUID categoryCode) {
        return productRepository.findByCodeCategory(code, categoryCode);
    }

    @Override
    public Product saveProduct(Product product, UUID categoryCode) {
        validateExistingProductCategory(categoryCode);
        validateDuplicateCategoryCode(product);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(UUID codeProduct, UUID codeCategory, Product product) {
        Product productSaved = validateExistingProduct(codeProduct, codeCategory);
        validateDuplicateCategoryCode(product);
        validateExistingProductCategory(codeCategory);
        BeanUtils.copyProperties(product, productSaved, "code");
        return productRepository.save(productSaved);
    }

    private Product validateExistingProduct(UUID codeProduct, UUID codeCategory) {
        Optional<Product> product = getByCodeCategory(codeProduct, codeCategory);
        if (product.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return product.get();
    }

    private void validateDuplicateCategoryCode(Product product) {
        Optional<Product> productByDescription = productRepository.findByCategoryCodeAndDescription(product.getCategory().getCode(), product.getDescription());
        if (productByDescription.isPresent() && productByDescription.get().getCode() != product.getCode()) {
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
