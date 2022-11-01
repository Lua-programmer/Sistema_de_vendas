package com.vendas.gestavendas.service;

import com.vendas.gestavendas.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    List<Product> getProducts();

    Optional<Product> getProductByCode(UUID code);

}
