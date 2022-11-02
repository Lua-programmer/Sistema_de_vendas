package com.vendas.gestavendas.repository;

import com.vendas.gestavendas.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    Optional<Product> findByCategoryCodeAndDescription(UUID codeCategory, String description);
}
