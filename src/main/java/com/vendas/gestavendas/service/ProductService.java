package com.vendas.gestavendas.service;

import com.vendas.gestavendas.entity.Product;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    List<Product> getProducts(UUID categoryCode);

    Optional<Product> getByCodeCategory(UUID code, UUID categoryCode);

    Product saveProduct(Product product, UUID categoryCode);

    Product updateProduct(UUID codeCategory, UUID codeProduct, Product product);

}
