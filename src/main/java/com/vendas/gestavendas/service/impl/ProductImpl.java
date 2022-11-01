package com.vendas.gestavendas.service.impl;

import com.vendas.gestavendas.entity.Product;
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

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductByCode(UUID code) {
        return productRepository.findById(code);
    }
}
